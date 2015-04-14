package alpvax.mod.classmodcore.config;

import java.util.Locale;

import net.minecraft.client.resources.I18n;

public enum ClassPickOptions
{
	ONCE, ON_DEATH, ALWAYS;

	@Override
	public String toString()
	{
		return I18n.format("classmodcore.config.rule.classselect." + name().toLowerCase(Locale.ENGLISH) + ".name");
	}

	public String getDescription()
	{
		return I18n.format("classmodcore.config.rule.classselect." + name().toLowerCase(Locale.ENGLISH) + ".desc");
	}
}
