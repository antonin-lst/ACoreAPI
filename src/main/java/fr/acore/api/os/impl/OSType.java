package fr.acore.api.os.impl;

import fr.acore.api.os.IOSType;
import fr.acore.api.os.process.factory.IExternalProcessFactory;
import fr.acore.api.os.process.factory.impl.MacOsExternalProcessFactory;
import fr.acore.api.os.process.factory.impl.SolarisExternalProcessFactory;
import fr.acore.api.os.process.factory.impl.UnixExternalProcessFactory;
import fr.acore.api.os.process.factory.impl.WindowsExternalProcessFactory;

import java.util.Arrays;
import java.util.List;

public enum OSType implements IOSType {

	WINDOWS(Arrays.asList("win"), new WindowsExternalProcessFactory()), UNIX(Arrays.asList("nix", "nux", "aix"), new UnixExternalProcessFactory()), MAC(Arrays.asList("mac"), new MacOsExternalProcessFactory()), SOLARIS(Arrays.asList("sunos"), new SolarisExternalProcessFactory());
	
	private List<String> tags;
	private IExternalProcessFactory processFactory;

	OSType(List<String> tags, IExternalProcessFactory processFactory) {
		this.tags = tags;
		this.processFactory = processFactory;
	}

	@Override
	public List<String> getTags() {
		return tags;
	}

	public boolean match(String osName){
		for(String tag : getTags()){
			if(osName.contains(tag)) return true;
		}
		return false;
	}

	@Override
	public IExternalProcessFactory getProcessFactory() {
		return processFactory;
	}

	public static IOSType getOsType(){
		return Arrays.stream(values()).filter(osType -> osType.match(IOSType.getCurrentOsName())).findFirst().orElse(null);
	}

}
