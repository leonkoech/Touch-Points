# Touch-Points

A java app that simulates touches on the screen where you last touched.

The touches are simply dispached with ```dispachTouchEvent()``` method with a ```MotionEvent``` object as the parameter.


## Abstract

When creating this app I wanted the app to interract with the system and simulate touches.
The  methods available for injecting events programmatically;

 1) Make the application a system app.
      Using this method I had two possible options.
      1) Using an instrumentation object
      2) Using internal APIs
      
      Sadly, both options required ```INJECT_EVENTS``` which is a system permission
      
      This is the exception it raises;
      
      ```java.lang.SecurityException: Injecting to another application requires INJECT_EVENTS permission```
      
 2) Root the device.
    Using this method I could just use a direct event injection to ```/dev/input/eventX```
    This option is pretty straight forward once you root your device.
    
### Limitation of the above methods

Because this app is a part of a bigger app which is supposed to go for production and be installed in people's devices,
the methods above could not be used.

 - No one wants an installed app to be a system app. (you cannot uninstall a system app).
 
 - Not everyone has rooted their device.
 
## Demo 

Here's a demo. The toast shows the input touchevent made by the user and the final touch event entered by the app

![touchpoints](https://user-images.githubusercontent.com/39020723/82736907-ae38b180-9d35-11ea-81cf-9d33e8e23038.gif)

## Contributions

Please read the [Contribution](#) guide.

## License

This project is under the [MIT](#) license
