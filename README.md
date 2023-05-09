# cucumber-testNG-smartui-hyperexecute-sample


### Steps to execute HyperExecute test with smartui feature


### Configure Environment Variables

Before the tests are run, please set the environment variables LT_USERNAME & LT_ACCESS_KEY from the terminal. The account details are available on your [LambdaTest Profile](https://accounts.lambdatest.com/detail/profile) page.

For macOS:

```bash
export LT_USERNAME=LT_USERNAME
export LT_ACCESS_KEY=LT_ACCESS_KEY
```

For Linux:

```bash
export LT_USERNAME=LT_USERNAME
export LT_ACCESS_KEY=LT_ACCESS_KEY
```

For Windows:

```bash
set LT_USERNAME=LT_USERNAME
set LT_ACCESS_KEY=LT_ACCESS_KEY
```




### Execute TestNG tests

Run the following command on the terminal to trigger the tests in Java files with HyperExecute platform
```bash
./hyperexecute --config hyperexecute.yaml --force-clean-artifacts
```
