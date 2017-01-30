# Settings

Run the settings help on the sbt command line and see if that points you to where source code for the project should go

```
> settings

This is a list of settings defined for the current project.
It does not list the scopes the settings are defined in; use the 'inspect' command for that.

  autoCompilerPlugins            If true, enables automatically generating -Xplugin arguments to the compiler based on the classpath for the plugin configuration.
  autoScalaLibrary               Adds a dependency on scala-library if true.
  baseDirectory                  The base directory.  Depending on the scope, this is the base directory for the build, project, configuration, or task.
  classDirectory                 Directory for compiled classes and copied resources.
  crossPaths                     If true, enables cross paths, which distinguish input and output directories for cross-building.
  fork                           If true, forks a new JVM when running.  If false, runs in the same JVM as the build.
  initialCommands                Initial commands to execute when starting up the Scala interpreter.
  javaHome                       Selects the Java installation used for compiling and forking.  If None, uses the Java installation running the build.
  javaSource                     Default Java source directory.
  libraryDependencies            Declares managed dependencies.
  logLevel                       The amount of logging sent to the screen.
  managedResourceDirectories     List of managed resource directories.
  maxErrors                      The maximum number of errors, such as compile errors, to list.
  name                           Project name.
  offline                        Configures sbt to work without a network connection where possible.
  organization                   Organization/group ID.
  publishArtifact                Enables (true) or disables (false) publishing an artifact.
  publishTo                      The resolver to publish to.
  resourceDirectory              Default unmanaged resource directory, used for user-defined resources.
  sbtVersion                     Provides the version of sbt.  This setting should be not be modified.
  scalaHome                      If Some, defines the local Scala installation to use for compilation, running, and testing.
  scalaSource                    Default Scala source directory.
  scalaVersion                   The version of Scala used for building.
  sourceDirectories              List of all source directories, both managed and unmanaged.
  sourceDirectory                Default directory containing sources.
  target                         Main directory for files generated by the build.
  unmanagedBase                  The default directory for manually managed libraries.
  unmanagedResourceDirectories   Unmanaged resource directories, containing resources manually created by the user.
  unmanagedSourceDirectories     Unmanaged source directories, which contain manually created sources.
  version                        The version/revision of the current module.

More settings may be viewed by increasing verbosity.  See 'help settings'.

> scalaVersion
[info] 2.10.6
```