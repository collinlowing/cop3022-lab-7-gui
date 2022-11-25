import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class BinaryConvertionViewer extends JFrame implements ActionListener
{
	private JTextArea output;
	private JButton zero;
	private JButton one;
	private JButton convert;
	
	public BinaryConvertionViewer()
	{
		super("Binary Convertion");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		output = new JTextArea(3,20);
		output.append("Enter numbers");
		this.add(output, BorderLayout.NORTH);
		
		zero = new JButton("0");
		zero.addActionListener(this);
		this.add(zero, BorderLayout.WEST);
		
		one = new JButton("1");
		one.addActionListener(this);
		this.add(one, BorderLayout.EAST);
		
		convert = new JButton("Convert");
		convert.addActionListener(this);
		this.add(convert, BorderLayout.SOUTH);
		
		this.pack();
	}
	
	public void actionPerformed (ActionEvent pushed)
	{
		Object src = pushed.getSource();
		if(src.equals(one))
		{
			if(output.getText().equals("Enter numbers") || output.getText().contains("Binary input:"))
			{
				output.setText("1");
			}
			else
			{
				output.append("1");
			}
		}
		else if(src.equals(zero))
		{
			if(output.getText().equals("Enter numbers"))
			{
				output.setText("0");
			}
			else
			{
				output.append("0");
			}
		}
		else if(src.equals(convert))
		{
			output.setText("Binary input: " + output.getText() + "\nDecimal convertion: " + convertBin(output.getText()));
		}
	}
	
	private static Integer convertBin(String bin)
	{
		return Integer.parseInt(bin, 2);
	}
	
	public static void main(String[] args)
	{
		BinaryConvertionViewer bincalc = new BinaryConvertionViewer();
		bincalc.setVisible(true);
	}
}
