package com.eshop.main;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import com.eshop.service.EbuyService;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EshopMain extends Application<EshopConfiguration >{
	public static void main(String[] args) throws Exception {
		new EshopMain().run(args);
	}

	@Override
	public void initialize(Bootstrap<EshopConfiguration> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(EshopConfiguration configuration, Environment environment) throws Exception {
		final EbuyService resource = new EbuyService(
                configuration.getTemplate(),
                configuration.getDefaultName()
            );
            environment.jersey().register(resource);     
	}
}
