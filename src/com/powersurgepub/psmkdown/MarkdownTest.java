/*
 * Copyright 2013 - 2013 Herb Bowie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.powersurgepub.psmkdown;

  import com.powersurgepub.pstextio.*;
  import java.io.*;
  import javax.swing.*;

/**
 Test the markdown routines.

 @author hbowie
 */
public class MarkdownTest extends javax.swing.JFrame {
  
  private    JFileChooser       chooser;
  private    TextLineReader     lineReader = null;

  /**
   Creates new form MarkdownTest
   */
  public MarkdownTest() {
    initComponents();
  }
  
  private void fileOpen() {
    chooser = new JFileChooser();
    int result = chooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
      File mdFile = chooser.getSelectedFile();
      MarkdownDoc doc = new MarkdownDoc();
      lineReader = new FileLineReader (mdFile);
      boolean ok = lineReader.open();
      if (ok) {
        String line = lineReader.readLine();
        while (lineReader.isOK() 
            && (! lineReader.isAtEnd())
            && line != null) {
          MarkdownLine mdLine = new MarkdownLine (doc, line);
          mdLine.display();
          doc.display();
          line = lineReader.readLine();
        }
        lineReader.close();
      }
    }
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    openButton = new javax.swing.JButton();
    resultsScrollPane = new javax.swing.JScrollPane();
    resultsTextArea = new javax.swing.JTextArea();
    jMenuBar1 = new javax.swing.JMenuBar();
    fileMenu = new javax.swing.JMenu();
    fileOpenMenuItem = new javax.swing.JMenuItem();
    editMenu = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new java.awt.GridBagLayout());

    openButton.setText("Open");
    openButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        openButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    getContentPane().add(openButton, gridBagConstraints);

    resultsTextArea.setColumns(20);
    resultsTextArea.setRows(5);
    resultsScrollPane.setViewportView(resultsTextArea);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    getContentPane().add(resultsScrollPane, gridBagConstraints);

    fileMenu.setText("File");

    fileOpenMenuItem.setText("Open...");
    fileOpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fileOpenMenuItemActionPerformed(evt);
      }
    });
    fileMenu.add(fileOpenMenuItem);

    jMenuBar1.add(fileMenu);

    editMenu.setText("Edit");
    jMenuBar1.add(editMenu);

    setJMenuBar(jMenuBar1);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
    fileOpen();
  }//GEN-LAST:event_openButtonActionPerformed

  private void fileOpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenMenuItemActionPerformed
    fileOpen();
  }//GEN-LAST:event_fileOpenMenuItemActionPerformed

  /**
   @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MarkdownTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MarkdownTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MarkdownTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MarkdownTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MarkdownTest().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu editMenu;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JMenuItem fileOpenMenuItem;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JButton openButton;
  private javax.swing.JScrollPane resultsScrollPane;
  private javax.swing.JTextArea resultsTextArea;
  // End of variables declaration//GEN-END:variables
}
