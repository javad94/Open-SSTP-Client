package kittoku.osc.preference.custom

import android.content.Context
import android.util.AttributeSet
import androidx.preference.CheckBoxPreference
import kittoku.osc.preference.OscPreference
import kittoku.osc.preference.accessor.getBooleanPrefValue


internal abstract class ModifiedCheckBoxPreference(context: Context, attrs: AttributeSet) : CheckBoxPreference(context, attrs) {
    abstract val oscPreference: OscPreference
    abstract val preferenceTitle: String

    private fun initialize() {
        isChecked = getBooleanPrefValue(oscPreference, sharedPreferences!!)
    }

    override fun onAttached() {
        super.onAttached()

        initialize()

        title = preferenceTitle
        isSingleLineTitle = false
    }
}

internal class SSLDoVerifyPreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPreference = OscPreference.SSL_DO_VERIFY
    override val preferenceTitle = "Verify Hostname"
}

internal class PPPPapEnabledPreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPreference = OscPreference.PPP_PAP_ENABLED
    override val preferenceTitle = "Enable PAP"
}

internal class PPPMsChapv2EnabledPreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPreference = OscPreference.PPP_MSCHAPv2_ENABLED
    override val preferenceTitle = "Enable MS-CHAPv2"
}

internal class PPPIPv4EnabledPreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPreference = OscPreference.PPP_IPv4_ENABLED
    override val preferenceTitle = "Enable IPv4"
}

internal class PPPIPv6EnabledPreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPreference = OscPreference.PPP_IPv6_ENABLED
    override val preferenceTitle = "Enable IPv6"
}

internal class RouteDoAddDefaultRoutePreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPreference = OscPreference.ROUTE_DO_ADD_DEFAULT_ROUTE
    override val preferenceTitle = "Add Default Route"
}

internal class RouteDoRoutePrivateAddresses(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPreference = OscPreference.ROUTE_DO_ROUTE_PRIVATE_ADDRESSES
    override val preferenceTitle = "Route Private/Unique-Local Addresses"
}
