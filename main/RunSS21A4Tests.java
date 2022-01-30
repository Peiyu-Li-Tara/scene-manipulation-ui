package main;
import grader.basics.execution.BasicProjectExecution;
import gradingTools.comp301ss21.assignment4.SS21Assignment4Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;
public class RunSS21A4Tests {
	static final int TIME_1 = 600, TIME_2 = 2000, SET_PROCESS_TIME_OUT_INDEX = 5;
	
	public static void main(String[] args) {
		// if you set this to false, grader steps will not be traced
		GraderBasicsTraceUtility.setTracerShowInfo(true);	
		// if you set this to false, all grader steps will be traced,
		// not just the ones that failed		
		GraderBasicsTraceUtility.setBufferTracedMessages(false);
		// Change this number if a test trace gets longer than 600 and is clipped
		GraderBasicsTraceUtility.setMaxPrintedTraces(TIME_1);
		// Change this number if all traces together are longer than 2000
		GraderBasicsTraceUtility.setMaxTraces(TIME_2);
		// Change this number if your process times out prematurely
		BasicProjectExecution.setProcessTimeOut(SET_PROCESS_TIME_OUT_INDEX);
		// You need to always call such a method
		SS21Assignment4Suite.main(args);
	}
}


