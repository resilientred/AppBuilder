package edu.depaul.cdm.madl.tools.ui;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import edu.depaul.cdm.madl.tools.ui.text.MadlTextTools;

public class MadlToolsPlugin extends AbstractUIPlugin {
	
	// The plug-in ID
	  public static final String PLUGIN_ID = "edu.depaul.cdm.madl.tools.ui"; //$NON-NLS-1$

	  // The shared instance
	  private static MadlToolsPlugin plugin;
	  private MadlTextTools madlTextTools;
	  
	  /**
	   * Returns the shared instance
	   * 
	   * @return the shared instance
	   */
	  public static MadlToolsPlugin getDefault() {
	    return plugin;
	  }
	  
	  /**
	   * The constructor
	   */
	  public MadlToolsPlugin() {
	   
	  }
	  
		/*
		 * (non-Javadoc)
		 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
		 */
		public void start(BundleContext context) throws Exception {
			super.start(context);
			plugin = this;
		}

		/*
		 * (non-Javadoc)
		 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
		 */
		public void stop(BundleContext context) throws Exception {
			plugin = null;
			super.stop(context);
		}

	  /**
	   * Respects images residing in any plug-in. If path is relative, then this bundle is looked up for
	   * the image, otherwise, for absolute path, first segment is taken as id of plug-in with image
	   * 
	   * @param path the path to image, either absolute (with plug-in id as first segment), or relative
	   *          for bundled images
	   * @return the image descriptor
	   */
	  public static ImageDescriptor findImageDescriptor(String path) {
	    final IPath p = new Path(path);

	    if (p.isAbsolute() && p.segmentCount() > 1) {
	      return AbstractUIPlugin.imageDescriptorFromPlugin(
	          p.segment(0),
	          p.removeFirstSegments(1).makeAbsolute().toString());
	    } else {
	      return getBundledImageDescriptor(p.makeAbsolute().toString());
	    }
	  }
	  /**
	   * Returns an image descriptor for the image file at the given plug-in relative path.
	   * 
	   * @param path the path
	   * @return the image descriptor
	   */
	  public static ImageDescriptor getBundledImageDescriptor(String path) {
	    return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	  }
	  
	  public synchronized MadlTextTools getMadlTextTools() {
	    if (madlTextTools == null) {
	    	//SS setting preferences to null explicitly
	      madlTextTools = new MadlTextTools(
	          getPreferenceStore()
	         );
	    }
	    return madlTextTools;
	  }
}