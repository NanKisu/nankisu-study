package com.study.java;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.stream.Stream;

public class StudyProcess {
	public static void main(String[] args) {
		ProcessHandle self = ProcessHandle.current();
		long PID = self.pid();
		ProcessHandle.Info procInfo = self.info();
		 
		Optional<String[]> processArgs = procInfo.arguments();
		Optional<String> cmd =  procInfo.commandLine();
		Optional<Instant> startTime = procInfo.startInstant();
		Optional<Duration> cpuUsage = procInfo.totalCpuDuration();
		 
	
		Stream<ProcessHandle> childProc = ProcessHandle.current().children();
		System.out.println(childProc.count());
		childProc.forEach(procHandle -> {
			procHandle.destroy();
		    System.out.println("Could not kill process " + procHandle.pid());
		});
	}
}
