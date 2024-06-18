package com.document;

import com.album.model.Album;
import com.document.model.Image;
import com.document.view.ImageCreateView;
import com.document.view.ImageUpdateView;
import com.document.view.ImageView;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-24T15:20:27+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageView toView(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageView imageView = new ImageView();

        imageView.setUuid( image.getUuid() );
        imageView.setName( image.getName() );
        imageView.setPathname( image.getPathname() );

        return imageView;
    }

    @Override
    public Image fromView(ImageView view) {
        if ( view == null ) {
            return null;
        }

        Image image = new Image();

        image.setUuid( view.getUuid() );
        image.setPathname( view.getPathname() );
        image.setName( view.getName() );

        return image;
    }

    @Override
    public Image update(ImageUpdateView updateView) {
        if ( updateView == null ) {
            return null;
        }

        Image image = new Image();

        image.setPathname( updateView.getPathname() );
        image.setName( updateView.getName() );
        image.setType( updateView.getType() );
        image.setFilesize( updateView.getFilesize() );
        image.setDateChanged( updateView.getDateChanged() );
        image.setMetadata( updateView.getMetadata() );
        List<Album> list = updateView.getAlbums();
        if ( list != null ) {
            image.setAlbums( new ArrayList<Album>( list ) );
        }

        return image;
    }

    @Override
    public Image create(ImageCreateView createView) {
        if ( createView == null ) {
            return null;
        }

        Image image = new Image();

        image.setUuid( createView.getUuid() );
        image.setPathname( createView.getPathname() );
        image.setName( createView.getName() );
        image.setType( createView.getType() );
        image.setFilesize( createView.getFilesize() );
        image.setDateChanged( createView.getDateChanged() );
        image.setMetadata( createView.getMetadata() );
        List<Album> list = createView.getAlbums();
        if ( list != null ) {
            image.setAlbums( new ArrayList<Album>( list ) );
        }

        return image;
    }
}
