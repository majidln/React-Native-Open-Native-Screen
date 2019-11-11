package com.openNativeScreen;

import android.content.Intent;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;


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
    public void startActivity(String activityToStart, @Nullable ReadableMap extraData, Promise promise) {

        try {
            Class<?> c = Class.forName(activityToStart);
            Intent intent = new Intent(getCurrentActivity(), c);

            ReadableMapKeySetIterator iterator = extraData.keySetIterator();

            while (iterator.hasNextKey()) {
                String key = iterator.nextKey();

                ReadableType type = extraData.getType(key);

                switch (type) {
                    case Null:
                        break;
                    case Boolean:
                        intent.putExtra(key, extraData.getBoolean(key));
                        break;
                    case Number:
                        intent.putExtra(key, extraData.getDouble(key));
                        break;
                    case String:
                        intent.putExtra(key, extraData.getString(key));
                        break;
                    case Map:
                        // TODO add map object
                        break;
                    case Array:
                        // TODO add array
                        break;
                }
            }

            getCurrentActivity().startActivity(intent);
        } catch (Exception ignored) {
            promise.reject(ignored);
        }
    
}
