package eventticket.com.event.Image;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ComfigImage {

    //pour l' image de profile pour User

    public static void saveimgUser(String uploaDirUser, String nomfileUser, MultipartFile multipartFile) throws IOException {

        Path UploadPathUser = Paths.get(uploaDirUser);

        if(!Files.exists(UploadPathUser)) {
            Files.createDirectories(UploadPathUser);
        }
        try(InputStream inputStream = multipartFile.getInputStream()){
            Path fichierPathUser = UploadPathUser.resolve(nomfileUser);

            Files.copy(inputStream, fichierPathUser, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe){
            throw new IOException("Impossible d'enregistrer le fichier image:" + nomfileUser, ioe);
        }
    }

    //pour l' image d'affiche des l'évennements

    public static void saveimgEvent(String uploaDirEvent, String nomfileEvent, MultipartFile multipartFile) throws IOException {

        Path UploadPathEvent = Paths.get(uploaDirEvent);

        if(!Files.exists(UploadPathEvent)) {
            Files.createDirectories(UploadPathEvent);
        }
        try(InputStream inputStream = multipartFile.getInputStream()){
            Path fichierPathEvent = UploadPathEvent.resolve(nomfileEvent);

            Files.copy(inputStream, fichierPathEvent, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe){
            throw new IOException("Impossible d'enregistrer le fichier image:" + nomfileEvent, ioe);
        }
    }
}
