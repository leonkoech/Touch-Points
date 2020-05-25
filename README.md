# Touch-Points

A java app that simulates touches on the screen where you last touched.

The taps are simply dispached with ```dispachTouchEvent()``` method with a ```MotionEvent``` object as the parameter.

The ```MotionEvent``` object  contains an *```ACTION_UP```* event. Which is the same event called when a user removes a finger from the touched screen.


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
    
    
### Limitations of the above methods


Because this app is a part of a bigger app which is supposed to go for production and be installed in people's devices,
the methods above could not be used.

 - No one wants an installed app to be a system app. (you cannot uninstall a system app).
 
 - Not everyone has rooted their device.
 
 
## Demo 

In the first activity I tapped a random point on the screen. 

The ```onTouchEvent()``` listens for the touch and displays it's x and y coordinates as the toast text.

The second activity displays the touch position and type made on the first activity. 

In the final activity the touch event is dispatched by calling the  ```dispachTouchEvent()``` within the ```oncreate()``` method.

The final activity also listens for touches with the ```onTouch()``` method and displays it's x and y coordinates in the toast.

![touchpoints](https://user-images.githubusercontent.com/39020723/82736907-ae38b180-9d35-11ea-81cf-9d33e8e23038.gif)


## Contributions

Please read the [Contribution](#) guide.


## License

This project is under the [MIT](https://github.com/leonkoech/Touch-Points/blob/master/LICENSE) license
