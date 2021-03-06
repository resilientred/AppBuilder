package xj.mobile.model.properties

/*
 *  Generated by xj.mobile.tool.ProcessType
 *  Created on: Fri May 17 11:14:05 CDT 2013
 */
class DeviceOrientation extends Property { 

  static values = [:]
  static names = [ 'Unknown', 'Portrait', 'PortraitUpsideDown', 'LandscapeLeft', 'LandscapeRight', 'FaceUp', 'FaceDown' ]

  static final DeviceOrientation Unknown = new DeviceOrientation('Unknown')
  static final DeviceOrientation Portrait = new DeviceOrientation('Portrait')
  static final DeviceOrientation PortraitUpsideDown = new DeviceOrientation('PortraitUpsideDown')
  static final DeviceOrientation LandscapeLeft = new DeviceOrientation('LandscapeLeft')
  static final DeviceOrientation LandscapeRight = new DeviceOrientation('LandscapeRight')
  static final DeviceOrientation FaceUp = new DeviceOrientation('FaceUp')
  static final DeviceOrientation FaceDown = new DeviceOrientation('FaceDown')

  String name
  
  private DeviceOrientation(name) { 
    this.name = name
    values[name] = this
  }

  String toIOSString() { 
    "UIDeviceOrientation${name}"
  }

  String toShortString() { 
    name
  }

  String toString() { 
    "DeviceOrientation.${name}"
  }

  static boolean isCompatible(value) { 
	(value instanceof String) || 
	(value instanceof List) 
  }

  static boolean hasValue(name) { 
    values.hasKey(name)
  }

  static DeviceOrientation getValue(name) { 
    values[name]
  }

}
