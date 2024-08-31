package com.example.ar_interior_design_tool.kotlin.interiordesigntool

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import com.example.ar_interior_design_tool.R
import com.google.ar.core.Session
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException
import com.example.ar_interior_design_tool.java.common.helpers.DepthSettings
import com.example.ar_interior_design_tool.java.common.helpers.FullScreenHelper
import com.example.ar_interior_design_tool.java.common.helpers.InstantPlacementSettings
import com.example.ar_interior_design_tool.kotlin.common.helpers.ARCoreSessionLifecycleHelper
import com.example.ar_interior_design_tool.java.common.samplerenderer.SampleRender

import com.google.ar.core.Config
import com.google.ar.core.Config.InstantPlacementMode
import com.google.ar.core.exceptions.CameraNotAvailableException
import com.google.ar.core.exceptions.UnavailableApkTooOldException
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException
import com.google.ar.core.exceptions.UnavailableSdkTooOldException

class ARInteriorDesignActivity : ComponentActivity() {

    // private static string object for the class basically
    companion object {
        private const val TAG = "ARInteriorDesignActivity"
    }

    // requestInstall(Activity, true) will triggers installation of
    // Google Play Services for AR if necessary.
    private var mUserRequestedInstall = true

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            // Do something if permission granted
            if (isGranted) {
                Log.i(TAG, "permission granted")
            } else {
                Log.i(TAG, "permission denied")
            }
        }

    //  helps with basic ARCore operations
    lateinit var arCoreSessionHelper: ARCoreSessionLifecycleHelper

    // not sure what these are for
    lateinit var view: ARInteriorDesignView
    lateinit var renderer: ARInteriorDesignRenderer

    val instantPlacementSettings = InstantPlacementSettings()
    val depthSettings = DepthSettings()

    // basically like a normal java constructor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        // Setup ARCore session lifecycle helper and configuration.
        arCoreSessionHelper = ARCoreSessionLifecycleHelper(this)

        setContentView(R.layout.activity_main)

        // requests permission to access camera using lambda expression
        // from above
        requestPermission.launch(Manifest.permission.CAMERA)
        requestPermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)

        // is used in LifecycleHelper I think
        arCoreSessionHelper.exceptionCallback =
            { exception ->
                val message =
                    when (exception) {
                        is UnavailableUserDeclinedInstallationException ->
                            "Please install Google Play Services for AR"
                        is UnavailableApkTooOldException -> "Please update ARCore"
                        is UnavailableSdkTooOldException -> "Please update this app"
                        is UnavailableDeviceNotCompatibleException -> "This device does not support AR"
                        is CameraNotAvailableException -> "Camera not available. Try restarting the app."
                        else -> "Failed to create AR session: $exception"
                    }
                Log.e(TAG, "ARCore threw an exception", exception)
                view.snackbarHelper.showError(this, message)
            }


        // Configure session features, including: Lighting Estimation, Depth mode, Instant Placement.
        arCoreSessionHelper.beforeSessionResume = ::configureSession
        lifecycle.addObserver(arCoreSessionHelper)

        // Set up the AR Interior Design renderer.
        renderer = ARInteriorDesignRenderer(this)
        lifecycle.addObserver(renderer)

        // Set up AR Interior Design UI.
        view = ARInteriorDesignView(this)
        lifecycle.addObserver(view)
        setContentView(view.root)

        // Sets up an example renderer using our ARInteriorDesignRenderer.
        SampleRender(view.surfaceView, renderer, assets)

        depthSettings.onCreate(this)
        instantPlacementSettings.onCreate(this)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        FullScreenHelper.setFullScreenOnWindowFocusChanged(this, hasFocus)
    }

    // Configure the session, using Lighting Estimation, and Depth mode.
    fun configureSession(session: Session) {
        session.configure(
            session.config.apply {
                                            // Note: can be changed vvv (AMBIENT_INTENSITY = lower quality
                                            // DISABLED = lowest quality
                lightEstimationMode = Config.LightEstimationMode.ENVIRONMENTAL_HDR

                // Depth API is used if it is configured in AR Interior Design's settings.
                depthMode =
                    if (session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)) {
                        Config.DepthMode.AUTOMATIC
                    } else {
                        Config.DepthMode.DISABLED
                    }

                // Instant Placement is used if it is configured in Hello AR's settings.
                instantPlacementMode =
                    if (instantPlacementSettings.isInstantPlacementEnabled) {
                        InstantPlacementMode.LOCAL_Y_UP
                    } else {
                        InstantPlacementMode.DISABLED
                    }
            }
        )
    }

}
