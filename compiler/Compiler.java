package compiler;

import ast.*;
import parser.Parser;
import codegen.*;
import visitor.*;
import lexer.*;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

/**
 *  The Compiler class contains the main program for compiling
 *  a source program to bytecodes
*/
public class Compiler {

	/**
	 * The Compiler class reads and compiles a source program
	 */

	String sourceFile;

    public Compiler( String sourceFile ) {
    	this.sourceFile = sourceFile;
    }

    void compileProgram() {
	try {
			Parser parser = new Parser( sourceFile );
			AST ast = parser.execute();

			System.out.println( "---------------AST-------------" );
			PrintVisitor printVisitor = new PrintVisitor();
			ast.accept( printVisitor );

			CountVisitor counter = new CountVisitor();
			ast.accept( counter );

			DrawVisitor visitor = new DrawVisitor( counter.getCount() );
			ast.accept( visitor );

			try {
				File imagefile = new File( sourceFile + ".png" );
				ImageIO.write( visitor.getImage(), "png", imagefile );
			} catch( Exception e ) {
				System.out.println( "Error in saving image: " + e.getMessage() );
			}

			final JFrame f = new JFrame();
			f.addWindowListener( new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					f.dispose();
					System.exit( 0 );
				}
			});

			JLabel imagelabel = new JLabel( new ImageIcon( visitor.getImage() ));
			f.add( "Center", imagelabel );
			f.pack();
			f.setSize(
				new Dimension(
					visitor.getImage().getWidth() + 30,
					visitor.getImage().getHeight() + 40
				)
			);
			f.setVisible( true );
			f.setResizable( false );
			f.repaint();
		} catch( Exception e ) {
			System.out.println( "********exception*******" + e.toString() );
		};
    }

    public static void main( String args[] ) {
        if ( args.length == 0 ) {
            System.out.println( "***Incorrect usage, try: java compiler.Compiler <file>" );
            System.exit(1);
        }
        (new Compiler(args[0])).compileProgram();
    }
}
