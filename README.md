# react-native-open-native-screen

## Getting started

`$ npm install react-native-open-native-screen --save`

### Mostly automatic installation

`$ react-native link react-native-open-native-screen`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`

2. Go to `node_modules` ➜ `react-native-open-native-screen` and add `OpenNativeScreen.xcodeproj`

3. In XCode, in the project navigator, select your project. Add `libOpenNativeScreen.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`

4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`

- Add `import com.reactlibrary.OpenNativeScreenPackage;` to the imports at the top of the file

- Add `new OpenNativeScreenPackage()` to the list returned by the `getPackages()` method

2. Append the following lines to `android/settings.gradle`:

```

include ':react-native-open-native-screen'

project(':react-native-open-native-screen').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-open-native-screen/android')

```

3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:

```

compile project(':react-native-open-native-screen')

```

## Usage

```javascript
import OpenNativeScreen from "react-native-open-native-screen";

OpenNativeScreen.startActivity(activityName, intentParameters);
```

### Start Android activity

for start Android activity you can `startActivity(nameOfActivity, paramaters, promise)` method like below:

```javascript
OpenNativeScreen.startActivity("com.open_screen_test.SecondActivity", {
  id: 12345,
  grade: 19.25,
  isPassed: true,
  name: "react native open native screen"
})
  .then(response => {
    console.log("response is: ", response);
  })
  .catch(error => {
    console.log("error is: ", error);
  });
```

you can access to parameters in your activity (in this example second activity) like below:

```java
Intent intent = getIntent();
double id = intent.getDoubleExtra("id", 0);
double grade = intent.getDoubleExtra("grade", 0d);
boolean isPassed = intent.getBooleanExtra("isPassed", false);
String name = intent.getStringExtra("name");
```

support parameters type:

1.  Number: you can access to all number type like int, float, double in getDoubleExtra in second activity
2.  String
3.  Boolean
4.  Array (coming soon)
5.  HashMap or Object (comming soon)

## Tips

To find activity name you have two choice:

1.  name_of_application_package + activity_name
2.  In android studio right click on class name and click on copy reference
