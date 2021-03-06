AppBuilder
==========

### 1. Clone the entire repository

Not everything is needed to build and run the plugins and RCP version, so only import the plugins into Eclipse as described below.

```$ git clone https://github.com/sstalin/AppBuilder.git```

### 2. Download and open Eclipse for RCP and RAP Developers

Open the [Eclipse Download Page](https://www.eclipse.org/downloads/) and choose "Eclipse for RCP and RAP Developers"

### 3. Import the MADL plugins into Eclipse

Via the Eclipse menu, choose File -> Import -> General -> Existing Projects into Workspace. Navigate to the ```Madl``` folder, select all of the plugins, and click Finish.

### 3.1. Import all Groovy projects into Eclipse

Via the Eclipse menu, choose File -> Import -> General -> Existing Projects into Workspace. Navigate to the ```Groovy``` top-level folder, select all of the plugins, and click Finish.

### 4. Install Groovy/Grails plugin

There will be a build error in the ```org.codehaus.groovy.eclipse.astviews``` project if the Groovy/Grails plugin is not installed because Groovy classes in that project will not be recognized by Eclipse. 

Open Help -> Eclipse Marketplace and search for "groovy" and install Groovy/Grails Tool Suite (GGTS) for Eclipse Kepler (4.3).

Note: Eclipse will need to be restarted for the installation to finish.

### 5. Run the MADL Plugin from Source

- Expand the ```edu.depaul.cdm.madl.eclipse.feature``` project.
- Right-click on ```feature.xml``` and choose Run configurations
- Add a new Run Configuration under Eclipse Application named MADL-Plugin
- The default can be left for all other settings
- Click Run
- A runtime Eclipse instance will startup with the plugin installed

**Important:** Once the runtime Eclipse instance starts, set the AppBuilder Home directory via Eclipse -> Preferences -> AppBuilder Preferences to the root of the AppBuilder directory. If the AppBuilder Home directory is not set, it's not possible to create a new project.

### 6. Run the MADL RCP Product from Source

- Close the runtime instance of Eclipse if it's still open
- Expand the ```edu.depaul.cdm.madl.bootstrap``` project
- Right-click on ```plugin.xml``` and choose Run configurations
- Add a new Run Configuration under Eclipse Application named MADL-RCP
- On the Main tab, under ```Run a product``` choose ```edu.depaul.cdm.madl.bootstrap.product```
- The default can be left for all other settings
- Click Run
- The MADL splash screen will display and a runtime instance of Eclipse will open the RCP version
- As before, set the AppBuilder Home directory before creating a new project

### 7. Install the MADL plugin from the Update Site

- Download and Open Eclipse 4.3 or higher from the [Eclipse Download Page](https://www.eclipse.org/downloads/)
- **Important:** First install the ```JDT Core patch for Groovy-Eclipse plugin```. This is required, otherwise the MADL plugin will throw runtime errors once installed. To install this patch, navigate to Help -> Eclipse Marketplace and search "groovy". Choose only the ```JDT Core patch for Groovy-Eclipse plugin```:

![JDT Core patch for Groovy-Eclipse plugin](http://3.bp.blogspot.com/-iNkXCKxtGbY/UySkrb6E56I/AAAAAAAACnI/LdQogTfys8A/s1600/groovy_install.jpg)

- Confirm the installation and restart Eclipse
- Once Eclipse restarts, navigate to Help -> Install New Software
- Click ```Add``` to setup the MADL update site
- Configure Name as "MADL Update Site"
- Configure Location as http://selab.cdm.depaul.edu/SEStudio/madl
- Select MADL IDE from the list of plugins and click Next to proceed with the installation
- As before, set the AppBuilder Home directory before creating a new project

### 8. Package the MADL plugin and Export to an Update Site for Distribution
- Right-click on the `edu.depaul.cdm.madl.eclipse.feature` project and choose ```Export```
- Choose Plug-in Development -> Deployable features and click Next
- Choose a location under the ```Directory``` field 

This will package and export all of the necessary files as jar libraries. 

Lastly, copy the exact file and folder structure to an update site, i.e.:

```
# Copy everything from the current directory excluding shell scripts to the update site
$ rsync -r --exclude=*.sh * madl@selab.cdm.depaul.edu:/var/www/html/SEStudio/madl
```

```
# Or, simply copy everything from the current directory to the update site
$ scp -r * madl@selab.cdm.depaul.edu:/var/www/html/SEStudio/madl
```

Note: The ```feature``` includes a ```category.xml```. To change the name of the plugin displayed to the user on install, edit the ```category.xml``` Name field. Currently, it's "MADL IDE."  

### 9. Package the RCP Product as a Downloadable Distribution
- Expand the ```edu.depaul.cdm.madl.bootstrap``` plug-in project
- Right click ```plugin.xml``` and select Export
- Choose Plug-in Development -> Eclipse product
- Select a Destination directory and click Finish
