package ThreadingTest;

import javax.swing.JLabel;

public class MyWorker extends SimpleWorker {

	private JLabel label;
	public MyWorker(JLabel label){
		this.label = label;
	}
	@Override
	public void doInBackground() throws Exception {
		int sum = 0;
		
		while(!isCancelled()) {
			sum += 5;
			publish(sum);
			//Thread.currentThread().sleep(500);
		}
		                                
	}
	
	public void process(int val){
		this.label.setText(Integer.toString(val));
	}
	
	public void done(String message){
		this.label.setText("At worker: " + message);
	}

}
