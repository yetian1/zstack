package org.zstack.header.identity.role.api;

import org.springframework.http.HttpMethod;
import org.zstack.header.identity.PolicyStatement;
import org.zstack.header.identity.PolicyVO;
import org.zstack.header.identity.StatementEffect;
import org.zstack.header.identity.role.RoleVO;
import org.zstack.header.message.APIMessage;
import org.zstack.header.message.APIParam;
import org.zstack.header.rest.RestRequest;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kayo on 2018/7/26.
 */
@RestRequest(path = "/identities/roles/{uuid}/actions",
        method = HttpMethod.PUT,
        isAction = true,
        responseClass = APIUpdateRoleEvent.class)
public class APIUpdateRoleMsg extends APIMessage implements RoleMessage {
    @APIParam(resourceType = RoleVO.class)
    private String uuid;
    @APIParam(maxLength = 255, required = false)
    private String name;
    @APIParam(maxLength = 2048, required = false)
    private String description;
    private List<PolicyStatement> statements;
    @APIParam(resourceType = PolicyVO.class, required = false)
    private List<String> policyUuids;

    public List<String> getPolicyUuids() {
        return policyUuids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PolicyStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<PolicyStatement> statements) {
        this.statements = statements;
    }

    public void setPolicyUuids(List<String> policyUuids) {
        this.policyUuids = policyUuids;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public static APIUpdateRoleMsg __example__() {
        APIUpdateRoleMsg msg = new APIUpdateRoleMsg();
        msg.setUuid(uuid());
        msg.setName("role-1");
        msg.setPolicyUuids(Arrays.asList(uuid()));
        PolicyStatement policy = new PolicyStatement();
        policy.setEffect(StatementEffect.Allow);
        policy.setName("test role");
        policy.setActions(Arrays.asList("org.zstack.header.identity.role.api.APIUpdateRoleMsg"));
        msg.setStatements(Arrays.asList(new PolicyStatement()));
        msg.setDescription("role for test");

        return msg;
    }

    @Override
    public String getRoleUuid() {
        return uuid;
    }
}
