package ThreadingTest;

import javax.swing.SwingUtilities;

public abstract class SimpleWorker extends Thread {
	
	private volatile boolean cancel = false;
	private String msg = "OK";
	public SimpleWorker(){
		
	}
	
	public abstract void doInBackground() throws Exception;
	
	protected void done(String msg){
		
	}
	
	protected void process(int val){
		
	}
	
	public void publish(final int val){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				process(val);
				
			}
		});
	}
	
	public void run(){
		try {
			doInBackground();
			//System.out.println("HERE");
		} catch (Exception ex) {
			cancel = true;
			msg = "interrupted";
			ex.printStackTrace();
		}finally{
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					done("OK");
					
				}
			});
		}
	}
	
	public void runWorkerAsync(){
		start();
	}
	
	public void tryStop(){
		interrupt();
	}
	
	public boolean isCancelled(){
		return cancel;
	}

}
