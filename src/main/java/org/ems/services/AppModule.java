package org.ems.services;
import org.apache.tapestry5.http.services.*;
import org.ems.services.impl.EmployeeServiceImpl;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.commons.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.ems.services.impl.LoginServiceImpl;
import  org.ems.dao.EmployeeDao;
import  org.ems.dao.impl.EmployeeDaoImpl;
import org.slf4j.Logger;

import java.io.IOException;

public class AppModule {


    public static void bind(ServiceBinder binder) {
        binder.bind(EmployeeService.class, EmployeeServiceImpl.class);
        binder.bind(LoginService.class, LoginServiceImpl.class);
        binder.bind(EmployeeDao.class, EmployeeDaoImpl.class); // Corrected binding
        // Add other service bindings as needed
    }

    // Add other service bindings as needed
    @Contribute(RequestHandler.class)
    public static void contributeRequestHandler(OrderedConfiguration<RequestHandler> configuration) {
        // Configuration code
    }



    public static void contributeFactoryDefaults(MappedConfiguration<String, Object> configuration) {
        configuration.override(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
        configuration.override(SymbolConstants.PRODUCTION_MODE, false);
        // Add other factory default overrides as needed
    }

    public static void contributeApplicationDefaults(MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
        configuration.add(SymbolConstants.HMAC_PASSPHRASE, "change this immediately");
        // Add other application defaults as needed
    }

    @Contribute(SymbolProvider.class)
    @ApplicationDefaults
    public static void setupEnvironment(MappedConfiguration<String, Object> configuration) {
        configuration.add(SymbolConstants.JAVASCRIPT_INFRASTRUCTURE_PROVIDER, "jquery");
        configuration.add(SymbolConstants.BOOTSTRAP_ROOT, "context:mybootstrap");
        // Add other environment setups as needed
    }

    public RequestFilter buildTimingFilter(final Logger log) {
        return new RequestFilter() {
            @Override
            public boolean service(Request request, Response response, RequestHandler handler) throws IOException {
                long startTime = System.currentTimeMillis();

                try {
                    return handler.service(request, response);
                } finally {
                    long elapsed = System.currentTimeMillis() - startTime;
                    log.info("Request time: {} ms", elapsed);
                }
            }
        };
    }

    @Contribute(RequestHandler.class)
    public void addTimingFilter(OrderedConfiguration<RequestFilter> configuration, @Local RequestFilter filter) {
        configuration.add("Timing", filter);
    }
}
