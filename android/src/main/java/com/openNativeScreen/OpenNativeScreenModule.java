package com.openNativeScreen;

import android.content.Intent;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;

import java.util.HashMap;

public class OpenNativeScreenModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public OpenNativeScreenModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "OpenNativeScreen";
    }

    @ReactMethod
    public void startActivity(String activityToStart, ReadableMap extraData, Promise promise) {


        try {
            Class<?> c = Class.forName(activityToStart);
            Intent intent = new Intent(getReactApplicationContext(), c);

            ReadableMapKeySetIterator iterator = extraData.keySetIterator();

            while (iterator.hasNextKey()) {
                String key = iterator.nextKey();

                // set key to intent
                intent.putExtra(key, extraData.getString(key));
            }

            getReactApplicationContext().startActivity(intent);
        } catch (Exception ignored) {
        }

    }
    
}
