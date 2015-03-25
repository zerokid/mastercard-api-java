package com.mastercard.api.partnerwallet.services.common;

import java.security.PrivateKey;

import com.mastercard.api.common.Connector;
import com.mastercard.api.common.Environment;

public abstract class AbstractPartnerService extends Connector {
	
	protected Environment environment;

    protected  String sandboxUrl;
    protected  String productionUrl;
    protected String mtfUrl;
	
	public AbstractPartnerService(Environment environment, String consumerKey, PrivateKey privateKey) {
		super(consumerKey, privateKey);
		this.environment = environment;
	}

	protected String getUrl() {
        switch(environment) {
            case PRODUCTION:
                return this.productionUrl;
            case SANDBOX:
                return this.sandboxUrl;
            case MTF:
            	return this.mtfUrl;
            default:
                return null;
        }
    }

	protected String getSandboxUrl() {
		return sandboxUrl;
	}

	protected void setSandboxUrl(String sandboxUrl) {
		this.sandboxUrl = sandboxUrl;
	}

	protected String getProductionUrl() {
		return productionUrl;
	}

	protected void setProductionUrl(String productionUrl) {
		this.productionUrl = productionUrl;
	}

	protected String getMtfUrl() {
		return mtfUrl;
	}

	protected void setMtfUrl(String mtfUrl) {
		this.mtfUrl = mtfUrl;
	} 

}
