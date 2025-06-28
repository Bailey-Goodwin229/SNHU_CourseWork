//Bailey Goodwin
//CS 250

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	//Updated images to match the corresponding place and information based on wellness/detox vacations
	//This displays the images in the appropriate size for the appropriate slide
	//It takes these pictures from the resource file according to it's name
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			//Imports the image for destination 1
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Sunset_at_Karon_Beach,_Phuket,_Thailand_author_Pather alexiy.JPG") + "'</body></html>";
		} else if (i==2){
			//imports the image for destination 2
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Sidemen_sawah_countryside_author_Paul Arps.jpg") + "'</body></html>";
		} else if (i==3){
			//imports the image for destination 3
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Uvita_Osa_Author_AamadorEsp.jpg") + "'</body></html>";
		} else if (i==4){
			//Imports the image for destination 4
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Sacred_Valley_Peru_author_Chris_Jackson.jpg") + "'</body></html>";
		} else if (i==5){
			//Imports the image for destination 5
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Tangier_hill_Morocco_author_Alex_Lomas.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	//This changes the text to match the pictures along with a brief explanation of each place
	//This sets the size and font of the writing
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			//wander-mag.com 5 secluded places for a private wellness retreat
			text = "<html><body><font size='5'>#1 Karon, Phuket, Thailand</font> <br>Stunning beach with morning meditation and yoga, great for wellness healing.</body></html>";
		} else if (i==2){
			//wander-mag.com 5 secluded places for a private wellness retreat
			text = "<html><body><font size='5'>#2 Sidemen Valley, Bali</font> <br>Offers sunrise mountain meditations, water blessings, sacred ceremonies , and herbal baths.</body></html>";
		} else if (i==3){
			//wander-mag.com 5 secluded places for a private wellness retreat
			text = "<html><body><font size='5'>#3 Uvita, Costa Rica</font> <br>Go for a swim in the ocean, hike along jungle trails, engage in shamaniac breathework, cacoa ceremonies and dance therapy under the stars!</body></html>";
		} else if (i==4){
			//wander-mag.com 5 secluded places for a private wellness retreat
			text = "<html><body><font size='5'>#4 Sacred Valley, Peru</font> <br>Be involved in high-altitude yoga/breathework, explore ancient ruins and take place in healing ceremonies.</body></html>";
		} else if (i==5){
			//wander-mag.com 5 secluded places for a private wellness retreat
			text = "<html><body><font size='5'>#5 The Hills of Tangier, Morocco</font> <br>Try Sufi breathework, reflect on life in olive grove walks, see stunning sun sets and have spiritual spa experiences.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}