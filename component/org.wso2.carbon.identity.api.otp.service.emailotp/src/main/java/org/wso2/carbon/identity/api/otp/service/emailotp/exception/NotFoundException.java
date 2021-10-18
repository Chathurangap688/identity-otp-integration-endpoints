/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.com).
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.api.otp.service.emailotp.exception;

import org.apache.http.HttpHeaders;
import org.wso2.carbon.identity.api.otp.service.emailotp.dto.Error;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Not Found Exception.
 */
public class NotFoundException extends WebApplicationException {

    private String message;

    public NotFoundException(Error error) {

        super(Response.status(Response.Status.NOT_FOUND).entity(error)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build());
        message = error.getDescription();
    }

    public NotFoundException() {

        super(Response.Status.NOT_FOUND);
    }

    @Override
    public String getMessage() {

        return message;
    }
}
