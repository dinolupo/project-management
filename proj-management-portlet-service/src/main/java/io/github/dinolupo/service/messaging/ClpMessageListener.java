package io.github.dinolupo.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import io.github.dinolupo.service.ClpSerializer;
import io.github.dinolupo.service.EntryLocalServiceUtil;
import io.github.dinolupo.service.EntryServiceUtil;
import io.github.dinolupo.service.ProjectLocalServiceUtil;
import io.github.dinolupo.service.ProjectServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            EntryLocalServiceUtil.clearService();

            EntryServiceUtil.clearService();
            ProjectLocalServiceUtil.clearService();

            ProjectServiceUtil.clearService();
        }
    }
}
