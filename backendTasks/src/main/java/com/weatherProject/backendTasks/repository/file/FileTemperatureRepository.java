package com.weatherProject.backendTasks.repository.file;

import com.weatherProject.backendTasks.entity.Temperature;
import com.weatherProject.backendTasks.repository.TemperatureRepositoryInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Repository
public class FileTemperatureRepository implements TemperatureRepositoryInterface {

    @Value("temperatures.file.location")
    private File file;

    @Override
    public Temperature add(Temperature temperature) {
        long lastId = list().stream().map(Temperature::getId).max(Long::compare).orElse(0L);
        temperature.setId(lastId+1);

        FileWriter writer;
        try {
            writer=new FileWriter(file, true);
            writer.write(temperature.getId()+";"+
                    temperature.getKelvin()+";"+
                    temperature.getNameCity()+";"+
                    temperature.getIdCity()+";"+
                    temperature.getRecordCreated()+"/n"
            );
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Temperature on" + temperature.getNameCity() + " at unix Time" + temperature.getRecordCreated() + " has been created");
        return temperature;
    }
    @Override
    public List<Temperature> list() {

        List<Temperature> temperatures = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            for(String line; (line = br.readLine()) != null; )  {
                final Temperature temperature = new Temperature();
                final String[] allProperties = line.split("\\;");
                temperature.setId(Long.parseLong(allProperties[0]));
                temperature.setKelvin(Long.parseLong(allProperties[1]));
                temperature.setNameCity(allProperties[2]);
                temperature.setIdCity(allProperties[3]);
                temperature.setRecordCreated(Long.parseLong(allProperties[4]));
                temperatures.add(temperature);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A temperature from the file does not have a proper id");
            e.printStackTrace();
        }
        return temperatures;
    }

    @Override
    public Temperature getById(long id) {
        final Temperature temperature = new Temperature();
        temperature.setId(id);
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {

                final String[] allProperties = line.split("\\;");
                final long nextTemperatureId=Long.parseLong(allProperties[0]);
                if (nextTemperatureId==id) {
                    temperature.setKelvin(Long.parseLong(allProperties[1]));
                    temperature.setNameCity(allProperties[2]);
                    temperature.setIdCity(allProperties[3]);
                    temperature.setRecordCreated(Long.parseLong(allProperties[4]));
                    return temperature;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A temperature from the file does not have a proper id");
            e.printStackTrace();
        }
        temperature.setKelvin(null);
        temperature.setNameCity("UNKNOWN");
        temperature.setIdCity("UNKNOWN");
        temperature.setRecordCreated(null);
        return temperature;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}