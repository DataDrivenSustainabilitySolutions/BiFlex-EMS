package io.openems.edge.common.channel;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import io.openems.edge.common.channel.doc.ChannelId;
import io.openems.edge.common.channel.doc.OptionsEnum;
import io.openems.edge.common.component.OpenemsComponent;

public class EnumWriteChannel extends EnumReadChannel implements WriteChannel<Integer> {

	public EnumWriteChannel(OpenemsComponent component, ChannelId channelId) {
		super(component, channelId);
	}

	public EnumWriteChannel(OpenemsComponent component, ChannelId channelId, OptionsEnum optionsEnum) {
		super(component, channelId, optionsEnum);
	}

	private Optional<Integer> nextWriteValueOpt = Optional.empty();

	/**
	 * Internal method. Do not call directly.
	 * 
	 * @param value
	 */
	@Deprecated
	@Override
	public void _setNextWriteValue(Integer value) {
		this.nextWriteValueOpt = Optional.ofNullable(value);
	}

	/**
	 * Internal method. Do not call directly.
	 * 
	 * @return
	 */
	@Deprecated
	@Override
	public Optional<Integer> _getNextWriteValue() {
		return this.nextWriteValueOpt;
	}

	/*
	 * onSetNextWrite
	 */
	@Override
	public List<Consumer<Integer>> getOnSetNextWrites() {
		return super.getOnSetNextWrites();
	}

	@Override
	public void onSetNextWrite(Consumer<Integer> callback) {
		this.getOnSetNextWrites().add(callback);
	}

}