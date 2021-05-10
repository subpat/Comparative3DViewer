package com.subhadeep.AndroidApp.view.activity4_extra;

import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.text.Spannable;
import android.view.ViewGroup;
import android.graphics.Color;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.text.SpannableString;
import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import android.text.style.ForegroundColorSpan;


import com.subhadeep.AndroidApp.model.fragment_data.Camera;
import com.subhadeep.AndroidApp.model.fragment_data.ChangedCameraData;
import com.subhadeep.AndroidApp.model.fragment_data.ResetModelData;
import com.subhadeep.AndroidApp.model.fragment_data.ToggleSyncData;
import com.subhadeep.AndroidApp.model.settings_data.Window;
import com.subhadeep.AndroidApp.model.fragment_data.Point2D;
import com.subhadeep.AndroidApp.utils.AppConstants;
import com.subhadeep.AndroidApp.model.fragment_data.DataHolder;
import com.subhadeep.AndroidApp.R;
import com.subhadeep.AndroidApp.model.settings_data.SettingsData;
import com.subhadeep.AndroidApp.view_model.ViewModel4_View3DModel;

import javax.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class KiwiFragment extends Fragment implements KiwiFragmentInterface, Observer<Object> {

    private String name;
    private boolean movementSynced;
    private ViewModel4_View3DModel viewModel4_view3DModel;

    //This is the view within the fragment used to display the 3D model.
    private Window window;
    private KiwiGLSurfaceView mView;

    private DataHolder<Point2D> positionLegendVertical;
    private DataHolder<Point2D> positionLegendHorizontal;
    private DataHolder<Point2D> positionLegendVerticalReversed;
    private DataHolder<Point2D> positionLegendHorizontalReversed;

    private TextView legend = null;
    private OrientationEventListener myOrientationEventListener;
    private DataHolder<AppConstants.ORIENTATION> lastKnowOrientation;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getTag();
        movementSynced = AppConstants.SYNCHRONIZED_MOVEMENT_INIT; // todo default

        myOrientationEventListener = new OrientationEventListener(getContext(), SensorManager.SENSOR_DELAY_NORMAL) {
            @Override
            public void onOrientationChanged(int angle) {
                AppConstants.ORIENTATION currentOrientation = AppConstants.ORIENTATION.findOrientation(angle);
                if (lastKnowOrientation != null && currentOrientation != AppConstants.ORIENTATION.UNDEFINED && currentOrientation != lastKnowOrientation.getValue()) {
                    if (mView != null) mView.onOrientationChanged(lastKnowOrientation.getValue(), currentOrientation); // rotate the 3d model
                    switch (currentOrientation) {
                        case UNDEFINED:
                            break;
                        case ZERO:
                            moveLegendAndRotate(positionLegendHorizontal.getValue(), 0);
                            break;
                        case NINETY:
                            moveLegendAndRotate(positionLegendVertical.getValue(), 270);
                            break;
                        case HUNDRED_EIGHTY:
                            moveLegendAndRotate(positionLegendHorizontalReversed.getValue(), 180);
                            break;
                        case TWO_SEVENTY:
                            moveLegendAndRotate(positionLegendVerticalReversed.getValue(), 90);
                            break;
                    }
                    lastKnowOrientation.setValue(currentOrientation);
                }
            }
        };
    }

    private void moveLegendAndRotate(Point2D point2D, int rotation){
        if(legend != null) {
            legend.setX((float) point2D.getX());
            legend.setY((float) point2D.getY());
            legend.setZ(100000); // an arbitrary bullshit value, but very very important for bugs in Nexus 6. Has to be atleast 10000.
            legend.setRotation(rotation);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.kiwi_fragment, container, false);
    }

    @Override
    public void onPause() {
        if (myOrientationEventListener.canDetectOrientation())
            myOrientationEventListener.disable();
        if (mView != null)
            mView.generateRestoreCamera();
        super.onPause();
    }


    @Override
    public void onResume() {
        try{
            if (myOrientationEventListener.canDetectOrientation())
                myOrientationEventListener.enable();
            mView = this.getView().findViewById(R.id.kiwiFragmentSurfaceView);
            Log.i("Fragment this is", this.getTag() + "\t" + window.getName());
        }
        catch(Exception exceptionResume) {
            Log.i("TAGG","exceptionResume = " + exceptionResume.toString());
        }
        finally {
            super.onResume();
        }
    }

    private Spannable generateLegend(){
        boolean usesTwoModels = (window.getModelTwo() != null)? true: false;
        String legendText = " ■ " + window.getModelOne().getFileName() + " ";
        if(usesTwoModels) {
            legendText += "\n ■ " + window.getModelTwo().getFileName() + " ";
        }
        Spannable spannable = new SpannableString(legendText);
        spannable.setSpan(new ForegroundColorSpan(Color.rgb(window.getModelOne().getColor().getR(),
                window.getModelOne().getColor().getG(), window.getModelOne().getColor().getB())),
                legendText.indexOf("■"), legendText.indexOf("■") + window.getModelOne().getFileName().length() + 3,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        if(usesTwoModels) {
            spannable.setSpan(new ForegroundColorSpan(Color.rgb(window.getModelTwo().getColor().getR(),
                    window.getModelTwo().getColor().getG(), window.getModelTwo().getColor().getB())),
                    legendText.lastIndexOf("■"), legendText.lastIndexOf("■") + window.getModelTwo().getFileName().length() + 3,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        }
        return spannable;
    }

    private void createLegend(){
        final Spannable text = generateLegend();
        final TextView legendViewHorizontal = getView().findViewById(R.id.textViewHorizontal);
        legend = legendViewHorizontal;
        legendViewHorizontal.setText(text);
        //legendViewHorizontal.setBackgroundColor(Color.rgb(textBG.getR(), textBG.getG(), textBG.getB()));
        legendViewHorizontal.setVisibility(View.VISIBLE);

        positionLegendHorizontal = new DataHolder<Point2D>(new Point2D());
        positionLegendHorizontalReversed = new DataHolder<Point2D>(new Point2D());
        positionLegendVertical = new DataHolder<Point2D>(new Point2D());
        positionLegendVerticalReversed = new DataHolder<Point2D>(new Point2D());

        legendViewHorizontal.postDelayed(new Runnable() {
            @Override
            public void run() {
                int legendWidth = legendViewHorizontal.getMeasuredWidth();
                int legendHeight = legendViewHorizontal.getMeasuredHeight();
                int windowWidth = mView.getWidth();
                int windowHeight = mView.getHeight();
                Log.i("SUBHADEEP TEXT", "WIDTH " + legendWidth + " , HEIGHT " + legendHeight);

                positionLegendHorizontal.getValue().setPoint(legendViewHorizontal.getX(), legendViewHorizontal.getY());
                positionLegendHorizontalReversed.getValue().setPoint(0, windowHeight - legendHeight);
                positionLegendVertical.getValue().setPoint(0 - legendWidth/2 + legendHeight/2, 0 + legendWidth/2 - legendHeight/2);
                positionLegendVerticalReversed.getValue().setPoint(windowWidth - legendWidth/2 - legendHeight/2, windowHeight - legendWidth/2 - legendHeight/2);
            }
        }, 100);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel4_view3DModel = new ViewModelProvider(getActivity()).get(ViewModel4_View3DModel.class);
        viewModel4_view3DModel.getSettingsData().observe(getViewLifecycleOwner(), this);
        viewModel4_view3DModel.getResetModelData().observe(getViewLifecycleOwner(), this);
        viewModel4_view3DModel.getToggleSyncData().observe(getViewLifecycleOwner(), this);
        viewModel4_view3DModel.getChangedCameraData().observe(getViewLifecycleOwner(), this);
    }

    @Override
    public void toggleSynchronization() {
        if (name != null && !name.isEmpty()) {
            movementSynced = !movementSynced;
            viewModel4_view3DModel.setToggleSyncData(name, movementSynced);
        }
    }

    @Override
    public void broadcastResetModelSignal() {
        if (name != null && !name.isEmpty())
            viewModel4_view3DModel.setResetModelData(name);
    }

    @Override
    public void cameraChanged(Camera camera) {
        if (name != null && !name.isEmpty())
            viewModel4_view3DModel.setChangedCameraData(name, camera);
    }

    @Override
    public void onChanged(Object data) {
        if (data instanceof SettingsData) {
            lastKnowOrientation = new DataHolder<>(AppConstants.ORIENTATION.ZERO);
            SettingsData settingsData = (SettingsData) data;
            if (name.equals(settingsData.getWindowOne().getName()))
                window = settingsData.getWindowOne();
            else
                window = settingsData.getWindowTwo();
            mView.init(this, window, lastKnowOrientation.getValue());
            createLegend();
        }
        else if (data instanceof ResetModelData) {
            String sourceName = ((ResetModelData) data).getFragmentName();
            if (movementSynced && sourceName!= null && !sourceName.equals(name) && mView!= null)
                mView.requestCameraToInitState();
        }
        else if (data instanceof ToggleSyncData) {
            ToggleSyncData toggleSyncData = (ToggleSyncData) data;
            if (toggleSyncData.getFragmentName() != null && !toggleSyncData.getFragmentName().equals(name) && mView!= null) {
                movementSynced = toggleSyncData.getData();
            }
        }
        else if (data instanceof ChangedCameraData) {
            ChangedCameraData changedCameraData = (ChangedCameraData) data;
            if (changedCameraData.getFragmentName() != null && !changedCameraData.getFragmentName().equals(name) && mView!= null) {
                mView.setCamera(changedCameraData.getCamera());
            }
        }
        else;
    }


}
