package com.github.wujiangtest.mvi2.other
import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.wujiangtest.mvi2.other.activity.mviActivityTemplate
import com.github.wujiangtest.mvi2.other.adapter.mviAdapterTemplate
import com.github.wujiangtest.mvi2.other.adapter2.mviAdapter2Template
import com.github.wujiangtest.mvi2.other.fragment.mviFragmentTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        mviActivityTemplate,
        mviFragmentTemplate,
        mviAdapterTemplate,
        mviAdapter2Template,
    )
}