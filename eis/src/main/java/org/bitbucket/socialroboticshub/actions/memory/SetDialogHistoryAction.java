package org.bitbucket.socialroboticshub.actions.memory;

import eis.iilang.Identifier;
import eis.iilang.Numeral;
import eis.iilang.Parameter;
import org.bitbucket.socialroboticshub.actions.RobotAction;

import java.util.List;

public class SetDialogHistoryAction extends RobotAction {
	public final static String NAME = "setDialogHistory";

	/**
	 * @param parameters A list of 3 identifiers: a (string) interactant id,
	 *                   a session id (number) and a (string) mini-dialog id.
	 */
	public SetDialogHistoryAction(final List<Parameter> parameters) {
		super(parameters);
	}

	@Override
	public boolean isValid() {
		return (getParameters().size() == 3) && (getParameters().get(0) instanceof Identifier)
				&& (getParameters().get(1) instanceof Numeral)
				&& (getParameters().get(2) instanceof Identifier);
	}

	@Override
	public String getTopic() {
		return "memory_set_dialog_history";
	}

	@Override
	public String getData() {
		return EIStoString(getParameters().get(0)) + ";" + EIStoString(getParameters().get(1)) + ';'
				+ EIStoString(getParameters().get(2));
	}

	@Override
	public String getExpectedEvent() {
		return "DialogHistorySet";
	}
}
