
package org.mule.modules.box.oauth;

import java.io.Serializable;
import javax.annotation.Generated;
import org.mule.api.store.ObjectStore;
import org.mule.common.security.oauth.OAuthState;
import org.mule.modules.box.adapters.BoxConnectorOAuth2Adapter;
import org.mule.modules.box.config.ConnectorConfig;
import org.mule.security.oauth.BaseOAuthClientFactory;
import org.mule.security.oauth.OAuth2Adapter;
import org.mule.security.oauth.OAuth2Manager;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-09-20T10:50:27-07:00", comments = "Build UNNAMED.2793.f49b6c7")
public class BoxConnectorOAuthClientFactory
    extends BaseOAuthClientFactory
{

    private BoxConnectorOAuthManager oauthManager;

    public BoxConnectorOAuthClientFactory(OAuth2Manager<OAuth2Adapter> oauthManager, ObjectStore<Serializable> objectStore) {
        super(oauthManager, objectStore);
        this.oauthManager = (BoxConnectorOAuthManager) oauthManager;
    }

    @Override
    protected Class<? extends OAuth2Adapter> getAdapterClass() {
        return (org.mule.modules.box.adapters.BoxConnectorRestClientAdapter.class);
    }

    @Override
    protected void setCustomAdapterProperties(OAuth2Adapter adapter, OAuthState state) {
        BoxConnectorOAuth2Adapter connector = ((BoxConnectorOAuth2Adapter) adapter);
        ((ConnectorConfig) connector.getConfig()).setGreeting(oauthManager.getGreeting());
        ((ConnectorConfig) connector.getConfig()).setReply(oauthManager.getReply());
    }

    @Override
    protected void setCustomStateProperties(OAuth2Adapter adapter, OAuthState state) {
        BoxConnectorOAuth2Adapter connector = ((BoxConnectorOAuth2Adapter) adapter);
    }

}
