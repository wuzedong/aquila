/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.List;

import org.codehaus.groovy.tools.shell.Shell;

import com.highgo.hgdbadmin.myutil.ShellEnvironment;

/**
 *
 */
public class DeleteCommand extends AquilaCommand {

	private DeleteDataTypeMapFunction deleteDataTypeMapFunction;

	public DeleteCommand(Shell shell) {
		super(shell, "delete", "\\d", new String[] { "datatypemap" }, "Delete", "info");
	}

	public Object executeCommand(List args) {
		if (!ShellEnvironment.isInteractive()) {
			throw new AquilaException(ShellError.SHELL_0007, "ls");
		}
		String func = (String) args.get(0);
		if (func.equals("datatypemap")) {
			if (deleteDataTypeMapFunction == null) {
				deleteDataTypeMapFunction = new DeleteDataTypeMapFunction();
			}
			deleteDataTypeMapFunction.execute(args);
		} else {
			ShellEnvironment.println("The specified function " + func + " is not recognized.");
			return null;
		}
		return null;
	}

}
