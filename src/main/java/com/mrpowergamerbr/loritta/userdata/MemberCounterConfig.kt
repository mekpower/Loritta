package com.mrpowergamerbr.loritta.userdata

import com.mrpowergamerbr.loritta.utils.counter.CounterThemeName
import com.mrpowergamerbr.loritta.utils.counter.CounterUtils
import net.dv8tion.jda.core.entities.Guild
import org.bson.codecs.pojo.annotations.BsonProperty

class MemberCounterConfig(
		@BsonProperty("topic")
		var topic: String,
		@BsonProperty("theme")
		var theme: CounterThemeName
) {
	var emojis: List<String> = mutableListOf()

	fun getFormattedTopic(guild: Guild): String {
		val emojis = if (theme == CounterThemeName.CUSTOM) {
			emojis
		} else {
			CounterUtils.getEmojis(theme)
		}

		return topic.replace("{guildsize}", guild.members.size.toString())
				.replace("{guild-size}", guild.members.size.toString())
				.replace("{counter}", CounterUtils.generatePrettyCounter(guild.textChannels.size, emojis))
	}
}