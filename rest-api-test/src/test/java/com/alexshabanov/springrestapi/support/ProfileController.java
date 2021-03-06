/*
 * Copyright 2012 Alexander Shabanov - http://alexshabanov.com.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alexshabanov.springrestapi.support;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that exposes REST API methods for working with {@link Profile} objects.
 * </p>
 * The sole purpose of this class is to provide testing grounds
 * for {@link com.alexshabanov.springrestapi.ControllerMockTest}
 * </p>
 */
@Controller
@RequestMapping(value = ProfileController.REST_API_METHOD_PREFIX)
public class ProfileController {

    public static final String REST_API_METHOD_PREFIX = "/rest/test";

    // Relative URLs for the exposed REST methods.
    public static final String COMPLETE_PROFILE_RESOURCE = "/profile/{id}/{name}";
    public static final String PROFILE_RESOURCE = "/profile";
    public static final String CONCRETE_PROFILE_RESOURCE = "/profile/{id}";

    @RequestMapping(COMPLETE_PROFILE_RESOURCE)
    @ResponseBody
    public Profile getProfile(@PathVariable("id") int id, @PathVariable("name") String name) {
        throw new AssertionError(); // should be mocked
    }

    @RequestMapping(value = PROFILE_RESOURCE, method = RequestMethod.POST)
    @ResponseBody
    public Profile upgradeProfile(@RequestBody Profile profile) {
        throw new AssertionError(); // should be mocked
    }

    @RequestMapping(value = PROFILE_RESOURCE, method = RequestMethod.PUT)
    @ResponseBody
    public void putQueryParam(@RequestParam(value = "a", required = false) Long a,
                              @RequestParam(value = "b", required = false) Long b,
                              @RequestParam("c") int c) {
        throw new AssertionError(); // should be mocked
    }

    @RequestMapping(value = CONCRETE_PROFILE_RESOURCE, method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfile(@PathVariable("id") long id) {
        throw new AssertionError(); // should be mocked
    }

    @RequestMapping(value = CONCRETE_PROFILE_RESOURCE, method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putProfile(@PathVariable("id") long id, @RequestBody Profile profile) {
        throw new AssertionError(); // should be mocked
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDesc handleIllegalArgumentException() {
        return new ErrorDesc();
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDesc handleUnsupportedOperationException() {
        throw new AssertionError();
    }
}
