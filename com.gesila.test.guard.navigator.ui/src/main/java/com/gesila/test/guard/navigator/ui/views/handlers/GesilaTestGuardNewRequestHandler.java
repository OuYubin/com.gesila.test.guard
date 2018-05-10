package com.gesila.test.guard.navigator.ui.views.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.gesila.test.guard.navigator.ui.wizards.GesilaTestGuardNewRequestWizard;

/**
 * 
 * @author robin
 *
 */
public class GesilaTestGuardNewRequestHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveMenuSelection(event);
		GesilaTestGuardNewRequestWizard gesilaTestGuardNewRequestWizard = new GesilaTestGuardNewRequestWizard();
		gesilaTestGuardNewRequestWizard.init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
		gesilaTestGuardNewRequestWizard.setNeedsProgressMonitor(true);
		WizardDialog wizardDialog = new WizardDialog(Display.getCurrent().getActiveShell(),
				gesilaTestGuardNewRequestWizard);
		wizardDialog.create();
		wizardDialog.open();
		return null;
	}

}
