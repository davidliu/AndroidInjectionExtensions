# AndroidInjectionExtensions [![](https://jitci.com/gh/davidliu/AndroidInjectionExtensions/svg)](https://jitci.com/gh/davidliu/AndroidInjectionExtensions)

For usage with [dagger-android](https://dagger.dev/android.html) to inject arbitrary types. `AndroidInjection` only supports the base framework type (i.e. Activity/Fragment/Service). This library traverses the context tree for any `HasAndroidInjector` to inject arbitrary types. Primary usage is really just for custom `View`, as most anything else shouldn't require this.

**Note:** [AssistedInject's InflationInject should be considered before resorting to this.](https://github.com/square/AssistedInject)

### Download:

```
implementation 'com.github.davidliu.AndroidInjectionExtensions:androidinjection-extensions:-SNAPSHOT'
```

### Usage:

Assuming thorough usage of Dagger.Android's framework types (i.e. `DaggerApplication/DaggerActivity/DaggerFragment`),

1. Replace `DaggerFragments` with `DaggerFragmentExt`. This will wrap the context given to Views so that the injection will work.
2. Call `AndroidInjectionExt.inject(View)` or `AndroidInjectionExt.inject(target, context)`

See the [sample code](/sample-app/src/main/java/com/deviange/androidinjection/sample/) here.
