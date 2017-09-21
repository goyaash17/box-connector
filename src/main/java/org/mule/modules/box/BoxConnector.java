package org.mule.modules.box;

import org.mule.api.annotations.oauth.OAuthPostAuthorization;  
import org.mule.api.annotations.oauth.OAuthProtected;
import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import java.io.IOException;
import org.mule.api.annotations.ReconnectOn;
import org.mule.api.annotations.rest.HttpMethod;
import org.mule.api.annotations.rest.RestCall;
import org.mule.api.annotations.rest.RestUriParam;

import org.mule.modules.box.config.ConnectorConfig;

@Connector(name="box", friendlyName="Box")
public abstract class BoxConnector {

    @Config
    ConnectorConfig config;

    /**
     * Custom processor
     *
     * @param friend Name of a friend we want to greet
     * @return The greeting and reply to the selected friend.
     * @throws IOException Comment for Exception
     */
    @Processor
    @OAuthProtected
    @RestCall(uri="https://api.box.com/2.0/files/{file_id}", method=HttpMethod.GET)
    public abstract void getFileInfo(@RestUriParam("file_id") String file_id) throws IOException;  

    @OAuthPostAuthorization
    public void postAuthorize() {
        //This method is called after authorization finishes. Remove if not required 
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}