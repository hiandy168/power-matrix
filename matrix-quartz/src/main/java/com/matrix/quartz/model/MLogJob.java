package com.matrix.quartz.model;

public class MLogJob {
	private String nextExecTime="";
	private MJobInfo jobInfo=null;

	public String getNextExecTime() {
		return nextExecTime;
	}
	public void setNextExecTime(String nextExecTime) {
		this.nextExecTime = nextExecTime;
	}
	public MJobInfo getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(MJobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}
}
