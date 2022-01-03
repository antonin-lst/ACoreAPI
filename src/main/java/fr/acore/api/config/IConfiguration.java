package fr.acore.api.config;

import fr.acore.api.files.FilesHelper;
import fr.acore.api.parser.conf.IParsedConfiguration;
import fr.acore.api.parser.node.INodeValue;
import fr.acore.api.string.IStringHelper;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*

Interface d'une classe de configuration

 */

public interface IConfiguration extends IStringHelper, FilesHelper {

	public String getInternalPath();

	public File getFile();

	//Object qui englobe un fichier de configuration cible parsée en ram
	public IParsedConfiguration<?,?> getParsedConfiguration();

	//charger le fichier de configuration
	public void load();

	//re charger les fields de configuration de la class
	public void reloadFromParsedConfiguration();

	//sauvegarde les fields de configuration dans le fichier de configurationParser
	public void save();


	//root section
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface Section {
		String getSectionRoot();
	}

	//node element config
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public static @interface Node {
		String getNodeRoot();
	}

	public default void loadFromInternalResource() throws IOException {
		if(!getFile().exists()) getFile().createNewFile();

		fileFromResource(getFile().toPath(), getInternalPath(), getClass().getClassLoader());
	}

	//getter des nodes config
	public default List<Field> getNodeFields(){
		return Arrays.stream(getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(Node.class)).collect(Collectors.toList());
	}

	public default boolean hasSection(){
		return getClass().isAnnotationPresent(Section.class);
	}

	public default String getFieldRoute(Field field){
		return hasSection() ? getClass().getAnnotation(Section.class).getSectionRoot() + "." + field.getAnnotation(Node.class).getNodeRoot() : field.getAnnotation(Node.class).getNodeRoot();
	}

	public default void loadField(Field field){
		String value = ((INodeValue) getParsedConfiguration().getNodeByRoute(getFieldRoute(field))).getAsString();
	}

}
