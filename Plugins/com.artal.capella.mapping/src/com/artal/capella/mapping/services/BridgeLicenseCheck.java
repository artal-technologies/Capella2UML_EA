package com.artal.capella.mapping.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.artal.licensing.ArtalFeature;
import com.artal.licensing.InvalidPrivilegeException;
import com.artal.licensing.LicenseUtils;

public abstract class BridgeLicenseCheck
{
	private static String HASH = "9AB30B430B388E3FC67F7DFCF66FFBC3";
	
	public BridgeLicenseCheck()
	{
		BridgeLicenseBypass bypass = OsgiServiceTrackerUtils.getService(BridgeLicenseBypass.class);
		
		if(bypass != null)
		{
			String password = bypass.getPassword();
			if(password != null)
			{
				try
				{
				    MessageDigest md = MessageDigest.getInstance("MD5");
			
				    md.update(password.getBytes());
	
				    byte[] digest = md.digest();
				    String myHash = DatatypeConverter
				      .printHexBinary(digest).toUpperCase();
				    
				    if(myHash.equals(HASH))
				    {
				    	try
				    	{
				    		action();
				    	}
				    	catch (ExecutionException e)
				    	{
				    		MessageDialog.openError(Display.getCurrent().getActiveShell(), "Execution exception", e.getMessage());
				    	}
				    	
				    	return;
				    	
				    }
				}
				catch (NoSuchAlgorithmException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		try
		{
			LicenseUtils.runWithPrivileges(new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						action();
					}
					catch (ExecutionException e)
					{
						MessageDialog.openError(Display.getCurrent().getActiveShell(), "Execution exception", e.getMessage());
					}
				}
			}, new ArtalFeature()
			{
				@Override
				public int getId()
				{
					return 1;
				}
			});
		}
		catch (InvalidPrivilegeException e1)
		{
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid Privilege", e1.getMessage());
		}
	}
	

	public abstract void action() throws ExecutionException;
}
