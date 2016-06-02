package prova.plugin.handlers;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MyTitleAreaDialogFixTitle extends TitleAreaDialog {

	private Text txtFixTitle;
	  

	  private String contextName;
	  private String title="Insert Fix Title",message="Insert the Title",lab="Title";
	  

	  public MyTitleAreaDialogFixTitle(Shell parentShell) {
	    super(parentShell);
	    
	  }

	  @Override
	  public void create() {
	    super.create();
	    setTitle(title);
	    setMessage(message, IMessageProvider.INFORMATION);
	  }

	  @Override
	  protected Control createDialogArea(Composite parent) {
	    Composite area = (Composite) super.createDialogArea(parent);
	    Composite container = new Composite(area, SWT.NONE);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    GridLayout layout = new GridLayout(2, false);
	    container.setLayout(layout);

	    createContextName(container);
	    

	    return area;
	  }

	  private void createContextName(Composite container) {
	    Label lbtFirstName = new Label(container, SWT.NONE);
	    lbtFirstName.setText(lab);

	    GridData dataFirstName = new GridData();
	    dataFirstName.grabExcessHorizontalSpace = true;
	    dataFirstName.horizontalAlignment = GridData.FILL;

	    txtFixTitle = new Text(container, SWT.BORDER);
	    txtFixTitle.setLayoutData(dataFirstName);
	  }
	  
	  


	  @Override
	  protected boolean isResizable() {
	    return true;
	  }

	  // save content of the Text fields because they get disposed
	  // as soon as the Dialog closes
	  private void saveInput() {
	    contextName = txtFixTitle.getText();
	   
	  }

	  @Override
	  protected void okPressed() {
		  if(txtFixTitle.getText().isEmpty())
		    	return;
		    super.okPressed();
	  }

	  public String getName() {
	    return contextName;
	  }

	  
}