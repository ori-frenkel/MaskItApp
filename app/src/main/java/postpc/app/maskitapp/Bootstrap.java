package postpc.app.maskitapp;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;

import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap extends Application {

    public Uri SavedUri;
    public String temp;
    Bitmap originalImage;
    // to backup image with filter applied
    Bitmap filteredImage;
    Bitmap filteredImage1;
    Bitmap blurredImage;
    // the final image after applying
    // brightness, saturation, contrast
    Bitmap finalImage;
    boolean loadimage;
    String currPhotoPath;

    String LoadLandscapePath ;
    Integer currentFilterNo;
    FaceDetector detector;
    List<Triplet<Rect, Integer, Canvas>> filters;
    List<TupleFace<Rect, Float>> _faces;

    @Override
    public void onCreate() {
        super.onCreate();
        LoadLandscapePath = "";
        filters = new ArrayList<>();
        _faces = new ArrayList<>();
        loadimage = false;
        FaceDetectorOptions highAccuracyOpts =
                new FaceDetectorOptions.Builder()
                        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
                        .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_NONE)
                        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_NONE)
                        .build();
        detector = FaceDetection.getClient(highAccuracyOpts);
    };
}
