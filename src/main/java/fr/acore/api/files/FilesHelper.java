package fr.acore.api.files;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public interface FilesHelper {

    /*

    Helper gestion des fichiers / dossiers

     */

    //supprésion d'un dossier
    public default boolean deleteDirectory(Path pathToDirectory) {
        try {
            //supprésion récursive des dossiers dans les dossiers
            Stream<Path> allContents = Files.list(pathToDirectory);
            if (allContents != null) {
                allContents.forEach(this::deleteDirectory);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //suppresion des fichier dans les dossier
        return deleteFile(pathToDirectory);
    }

    //suppretion d'un fichier
    public default boolean deleteFile(Path pathToFile){
        try {
            Files.delete(pathToFile);
            return true;
        } catch (NoSuchFileException x) {
            System.err.format("%s: Impossible de trouver le fichier %n", pathToFile);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s Dossier non vide%n", pathToFile);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
        return false;
    }

    //renomer un dossier
    public default Path renameDirectory(Path targetFile, Path newFile){
        try {
            Files.copy(targetFile, newFile);
            deleteDirectory(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    //chargée une ressource interne
    public default void fileFromResource(Path targetFile, String resource, ClassLoader classLoader){
        try{
            PrintWriter writer = new PrintWriter(Files.newBufferedWriter(targetFile));
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(classLoader.getResourceAsStream(resource))));
            String line;
            while((line = reader.readLine()) != null){
                writer.println(line);
            }
            reader.close();
            writer.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public default List<String> resourceToListedString(String resource, ClassLoader classLoader){
        List<String> result = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(classLoader.getResourceAsStream(resource))));
            String line;
            while((line = reader.readLine()) != null){
                result.add(line);
            }
        }catch (Exception ex){

        }
        return result;
    }

    //permet de convertir un fichier en une chaine de caractère
    public default String fileToString(Path pathToFile){
        try {
            return new String(Files.readAllBytes(pathToFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //permet de convertir un fichier en un tableau de chaine de caractère avec comme index la ligne
    public default Map<Integer, String> fileToIndexedString(Path pathToFile){
        try {
            Map<Integer, String> indexedString = new HashMap<>();
            int index = 0;
            for(String line : Files.readAllLines(pathToFile)){
                indexedString.put(index, line);
                index++;
            }
            return indexedString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //permet de décrire un tableau de chaine de caractère dans un PrintStream
    public default void printIndexedString(PrintStream printStream, Map<Integer, String> contents) {
        for(int i = 0; i < contents.size(); i++) printStream.println(contents.get(i));
    }

    public default boolean printIndexedString(Path path, Map<Integer, String> contents){
        try {
            PrintStream outputStream;
            printIndexedString(outputStream = new PrintStream(Files.newOutputStream(path)), contents);
            outputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    //permet de convertir un fichier en une list de chaine de caractère
    public default List<String> fileToListedString(Path pathToFile){
        try {
            return Files.readAllLines(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
