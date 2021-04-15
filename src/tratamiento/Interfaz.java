package tratamiento;
import weka.*;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.j48.C45PruneableClassifierTree;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.filters.unsupervised.attribute.StringToWordVector;
import weka.classifiers.Evaluation;
import weka.core.Debug.Random;
import weka.classifiers.bayes.BayesNet;

public class Interfaz extends javax.swing.JFrame {
    
    static double valorCoeficiente=0.30;
    
    static String texto;
    static int filas,columnas,col;
    static int cantAtributos,cantDatos;
    static String direccion;
    static double[][] matriz;
    static double[][] resultados; 
    static double a[];
    static double b[];
    static String[] attrib;
    static double atributos[];
    static double[][] nuevaMatriz;
    static double nClases;
    static double cantidad1,cantidad2;
    
    
    public Interfaz() {
        initComponents();
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        jButton6.setText("Ingresar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ingresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cantidad de datos:");

        jLabel2.setText("Cantidad de atributos:");

        jLabel3.setText("Direccion del archivo:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton3.setText("Ingresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Aceptar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad de clases:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton7.setText("Ingresar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel5.setText("Atributos con un coeficiente de correlacion alto");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel6.setText("Datos antes de aplicar la limpieza");

        jLabel7.setText("Datos despues de aplicar la limpieza");

        jButton8.setText("Mostrar Grafica");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton7)
                                            .addComponent(jButton2)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3))
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(118, 118, 118))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addGap(6, 6, 6))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(156, 156, 156))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(47, 47, 47))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cantDatos=Integer.parseInt(jTextField1.getText());
        System.out.println(cantDatos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        direccion=jTextField3.getText();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        Interfaz.leerArchivo();
        jTextArea1.setText("Datos sin procesar: ");
        try{
            BufferedReader breader=null;
            breader=new BufferedReader(new FileReader("Datos.arff"));
            Instances train=new Instances(breader);
            train.setClassIndex(train.numAttributes() -1);
            breader.close();
            NaiveBayes nb=new NaiveBayes();
            nb.buildClassifier(train);
            Evaluation eval=new Evaluation(train);
            eval.crossValidateModel(nb, train, 10, new Random(1));
            jTextArea1.setText("Clasificador Naive Bayes"+eval.toSummaryString("\nResusltados", true)+"Medida: "+eval.fMeasure(1)+" Precision: "+eval.precision(1)+" Recall: "+eval.recall(1));
            cantidad1=eval.pctCorrect();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        Interfaz.AnalisisCorrelacion();
        
        try{
            BufferedReader breader=null;
            breader=new BufferedReader(new FileReader("NuevosDatos.arff"));
            Instances train=new Instances(breader);
            train.setClassIndex(train.numAttributes() -1);
            breader.close();
            NaiveBayes nb=new NaiveBayes();
            nb.buildClassifier(train);
            Evaluation eval=new Evaluation(train);
            eval.crossValidateModel(nb, train, 10, new Random(1));
            jTextArea2.setText("Clasificador Naive Bayes"+eval.toSummaryString("\nResusltados", true)+"Medida: "+eval.fMeasure(1)+" Precision: "+eval.precision(1)+" Recall: "+eval.recall(1));
            cantidad2=eval.pctCorrect();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        jTextArea3.setText(texto);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextArea1.setText("");
        jTextArea2.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cantAtributos=Integer.parseInt(jTextField2.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        nClases=Integer.parseInt(jTextField4.getText());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try{
            DefaultCategoryDataset categoria = new DefaultCategoryDataset();
            String cla="Instancias clasificadas correctamente";
            String nocla="Instancias clasificadas incorrectamente";
            double cantidad3=100-cantidad1;
            double cantidad4=100-cantidad2;
            
            categoria.setValue(cantidad1, cla, "ANTES");
            categoria.setValue(cantidad3, nocla, "ANTES");
            categoria.setValue(cantidad2, cla, "DESPUES");
            categoria.setValue(cantidad4, nocla, "DESPUES");
            
            JFreeChart jf= ChartFactory.createBarChart3D("Tratamiento", "Antes y Despues de la limpieza", "Porcentaje", categoria, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame f=new ChartFrame("Antes y Despues",jf);
            f.setSize(1000,600);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }catch (Exception e){
        }
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    
    static void leerArchivo(){
        File archivo=null;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter archivo1 = null;
        PrintWriter pw = null;
        
        try {
            archivo=new File (direccion);
            fr=new FileReader (archivo);
            br=new BufferedReader(fr);
            String linea;
            
            archivo1=new FileWriter("Datos.arff");
            BufferedWriter bw = new BufferedWriter(archivo1);
            pw = new PrintWriter(bw);
            
            filas=cantDatos+1;
            columnas=cantAtributos+1;
            
            String[] numeros;
            matriz=new double[filas][columnas];
            
            resultados=new double[cantAtributos+1][cantAtributos];
            a=new double[cantDatos];
            b=new double[cantDatos];
            atributos=new double[columnas];
            
            double n,num;
            int cont=0,i=0;
            String aux;
            
            pw.println("@relation Datos");
            pw.println("");
            for(i=1;i<=cantAtributos;i++){
                pw.println("@attribute dato"+i+" real");
            }
            pw.print("@attribute clase {");
            for(i=0;i<nClases-1;i++){
                pw.print(i+",");
            }
            pw.print(i+"}");
            pw.println("");
            pw.println("@data");
            
            //Llenar matriz con los datos y los copia al documento .arff
            while((linea=br.readLine())!=null && cont<=filas){
                pw.println(linea);
                //System.out.println(linea);    
                numeros=linea.split(",");
                for(i=0;i<cantAtributos+1;i++){
                    n=Double.parseDouble(numeros[i]);
                    matriz[cont][i]=n;
                }
                cont+=1;   
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{                    
                if( null != fr ){   
                    fr.close();
                    pw.close();
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }   
        
        
    }
    
    
    
    static void AnalisisCorrelacion(){
        int contador=0;
        double correlacion;
        Regresion reg;
        
        for(int i=0;i<cantAtributos-1;i++){
            for(int j=i+1;j<cantAtributos;j++){
                
                for(int x=0;x<cantDatos;x++){
                        a[x]=matriz[x+1][i];
                        b[x]=matriz[x+1][j];
                    }
                    
                    reg=new Regresion(a,b);
                    correlacion=reg.correlacion();
                    resultados[i][j]=Math.abs(correlacion);
                    resultados[j][i]=Math.abs(correlacion);
            }
        }
        
        for (int x=0; x<resultados[0].length;x++){
            double suma=0;
            for (int y=0; y <resultados.length-1;y++)
                suma=suma+resultados[y][x];
            resultados[resultados.length-1][x]=suma;
        }
        
        int divisor=cantAtributos-1;
        for (int x=0; x <resultados[0].length;x++){
            resultados[resultados.length-1][x]=resultados[resultados.length-1][x]/divisor;
            if(resultados[resultados.length-1][x]>=valorCoeficiente){
                contador++;
            }
        }
        
        nuevaMatriz=new double[cantDatos][contador+1];
        
        int j=0;
        for(int i=0;i<resultados[0].length;i++){
            if(resultados[resultados.length-1][i]>=valorCoeficiente){
               for(int x=0;x<cantDatos;x++){
                    nuevaMatriz[x][j]=matriz[x][i];
                }
                j++;
            }
        }
        
        
        for(int x=0;x<cantDatos;x++){
            nuevaMatriz[x][nuevaMatriz[0].length-1]=matriz[x][matriz[0].length-1];
        }
        
        texto="";
        for(int x=0;x<resultados[0].length;x++){
            if(resultados[resultados.length-1][x]>=valorCoeficiente){
                int h=x+1;
                texto=texto +"dato"+h+"\n";
            }
        }
        
        
        FileWriter archivo2 = null;
        PrintWriter pw1 = null;
        
        try{
            int i;
            archivo2=new FileWriter("NuevosDatos.arff");
            BufferedWriter bw1 = new BufferedWriter(archivo2);
            pw1 = new PrintWriter(bw1);
            pw1.println("@relation NuevosDatos");
            pw1.println("");
            
            System.out.println("atribtos"+cantAtributos);
            
            System.out.println(contador);
            for(i=1;i<=contador;i++){
                pw1.println("@attribute dato"+i+" real");
            }
            pw1.print("@attribute clase {");
            
            double contx;
            for(contx=0;contx<nClases-1;contx++){
                pw1.print(contx+",");
            }
            pw1.print(contx+"}");
            pw1.println("");
            pw1.println("@data");
            
            int y;
            for(int x=0;x<nuevaMatriz.length;x++){
                for(y=0;y<nuevaMatriz[0].length-1;y++){
                    pw1.print(nuevaMatriz[x][y]+",");
                }
                pw1.print(nuevaMatriz[x][y]);
                pw1.println("");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        pw1.close();
    }
    
    
    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
