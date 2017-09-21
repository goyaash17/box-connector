
package org.mule.modules.box.oauth;

import java.io.Serializable;
import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.expression.ExpressionManager;
import org.mule.api.store.ObjectStore;
import org.mule.modules.box.BoxConnector;
import org.mule.modules.box.adapters.BoxConnectorOAuth2Adapter;
import org.mule.modules.box.config.ConnectorConfig;
import org.mule.security.oauth.BaseOAuth2Manager;
import org.mule.security.oauth.OAuth2Adapter;
import org.mule.security.oauth.OAuth2Manager;
import org.mule.security.oauth.OnNoTokenPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A {@code BoxConnectorOAuthManager} is a wrapper around {@link BoxConnector } that adds access token management capabilities to the pojo.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-20T10:50:27-07:00", comments = "Build UNNAMED.2793.f49b6c7")
public class BoxConnectorOAuthManager
    extends BaseOAuth2Manager<OAuth2Adapter>
{

    private static Logger logger = LoggerFactory.getLogger(BoxConnectorOAuthManager.class);

    @Override
    protected Logger getLogger() {
        return logger;
    }

    /**
     * Sets greeting
     * 
     * @param scope to set
     */
    public void setGreeting(String value) {
        BoxConnectorOAuth2Adapter connector = ((BoxConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        ((ConnectorConfig) connector.getConfig()).setGreeting(value);
    }

    /**
     * Retrieves greeting
     * 
     */
    public String getGreeting() {
        BoxConnectorOAuth2Adapter connector = ((BoxConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        return ((ConnectorConfig) connector.getConfig()).getGreeting();
    }

    /**
     * Sets reply
     * 
     * @param scope to set
     */
    public void setReply(String value) {
        BoxConnectorOAuth2Adapter connector = ((BoxConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        ((ConnectorConfig) connector.getConfig()).setReply(value);
    }

    /**
     * Retrieves reply
     * 
     */
    public String getReply() {
        BoxConnectorOAuth2Adapter connector = ((BoxConnectorOAuth2Adapter) this.getDefaultUnauthorizedConnector());
        return ((ConnectorConfig) connector.getConfig()).getReply();
    }

    /**
     * Sets consumerKey
     * 
     * @param key to set
     */
    public void setConsumerKey(String value) {
        super.setConsumerKey(value);
    }

    /**
     * Sets consumerSecret
     * 
     * @param secret to set
     */
    public void setConsumerSecret(String value) {
        super.setConsumerSecret(value);
    }

    @Override
    protected OAuth2Adapter instantiateAdapter() {
        return new org.mule.modules.box.adapters.BoxConnectorRestClientAdapter(this);
    }

    @Override
    protected KeyedPoolableObjectFactory createPoolFactory(OAuth2Manager<OAuth2Adapter> oauthManager, ObjectStore<Serializable> objectStore) {
        return new BoxConnectorOAuthClientFactory(oauthManager, objectStore);
    }

    @Override
    protected void setCustomProperties(OAuth2Adapter adapter) {
        BoxConnectorOAuth2Adapter connector = ((BoxConnectorOAuth2Adapter) adapter);
        ((ConnectorConfig) connector.getConfig()).setGreeting(getGreeting());
        ((ConnectorConfig) connector.getConfig()).setReply(getReply());
        ((ConnectorConfig) connector.getConfig()).setConsumerKey(getConsumerKey());
        ((ConnectorConfig) connector.getConfig()).setConsumerSecret(getConsumerSecret());
    }

    protected void fetchCallbackParameters(OAuth2Adapter adapter, String response) {
        BoxConnectorOAuth2Adapter connector = ((BoxConnectorOAuth2Adapter) adapter);
        ExpressionManager expressionManager = (muleContext.getExpressionManager());
        MuleMessage muleMessage = new DefaultMuleMessage(response, (muleContext));
    }

    public void setOnNoToken(OnNoTokenPolicy policy) {
        this.getDefaultUnauthorizedConnector().setOnNoTokenPolicy(policy);
    }

}
