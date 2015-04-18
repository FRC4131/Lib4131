#Lib4131#
A utility library for FRC 4131

This library is an addon to the WPILib libraries that are distributed by FIRST every year. It is written in and for Java, and contains a variety of useful utilities, including:
 - ["Pseudo" motor controllers that aren't attached to physical parts](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/PseudoMotor.java), so you can construct a `RobotDrive` with them and intercept the values they are being set to
 - Driver control components like [XBox One controllers](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/oi/XBoxController.java), [Logitech Attack 3 joysticks](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/oi/LogitechJoystick.java), and [TI Launchpad boards](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/oi/Launchpad.java)
 - Base classes for [components (subsystems)](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/subsystems/Component.java), [commands](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/commands/BaseCommand.java), [commands that execute instantaneously](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/commands/InstantCommand.java), and "[default commands](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/commands/DefaultCommand.java)" (commands that run constantly when a subsystem is not being used)
 - [Basic logging system](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/Robot.java#L27) through `Robot` class
 - Commands to [wait for a time](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/commands/WaitCommand.java) and [log a message](https://github.com/FRC4131/Lib4131/blob/master/src/org/usfirst/frc/team4131/lib/commands/LogCommand.java) (useful in command groups)

These plugins are not truly intended for use by anyone except ourselves, however it is most certainly open for use by anyone.
##Setup##
1. This library is not a replacement for WPILib. You must first install and configure Eclipse and the FRC plugins for the year, and have a command-based robot project created.
2. Download `lib4131.jar` to your computer.
3. In Eclipse, right-click project > Build Path > Configure Build Path > Libraries. Add `lib4131.jar` to the list.
4. Open the `build.properties` file for your project in your text editor of choice. Add the following line: `classpath=<wpi-path>:<nettable-path>:<lib4131-path>` where `<wpi-path>` is the path to `WPILib.jar` (on Windows this is usually `C:\Users\You\wpilib\java\current\lib\WPILib.jar`), `<nettable-path>` is the path to `NetworkTables.jar` (`C:\Users\You\wpilibj\java\current\lib\NetworkTables.jar`), and `<lib4131-path>` is the path to `lib4131.jar`. The paths can be absolute, or relative. The root is the project directory.
5. Refresh Eclipse to make sure the changes are registered.
6. Write your robot code.
7. Perform a WPILib Java Deploy, as you usually do, to push the code to the robot. The library will be pushed with it.
