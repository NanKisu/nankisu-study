package spring6;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TemporaryDirectory implements Serializable{
	private static final long serialVersionUID = 1L;
	private final File directory;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public File getDirectory() {
		return directory;
	}

	public TemporaryDirectory(
			@Value(value = "file://#{systemProperties['java.io.tmpdir']}/app") File baseDirectory,
			@Value(value = "#{T(java.util.UUID).randomUUID().toString()}") String id
			) {
		System.out.println(baseDirectory.getPath());
		System.out.println(id);
		directory = new File(baseDirectory, id);
		if(!directory.exists())
			directory.mkdir();
	}
}
