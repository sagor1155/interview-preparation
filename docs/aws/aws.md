# AWS
- Step function
- Lambda
- DynamoDB
- API Gateway
- SNS
- SQS
- S3 (S3 IA)
- Route 53
- Event Bridge
- App Config
- ECS
- EC2
- ELB
- EKS
- Kinesis
- Serverless framework


## Step Function
- AWS Step Functions is a powerful service for orchestrating and coordinating multiple AWS services
- **Workflow Orchestration:** allow you to define complex workflows by orchestrating multiple AWS services such as Lambda functions, S3, DynamoDB, ECS, and more.
- **State Management:** Step Functions manage the state of your workflows, 
  keeping track of the current state and the inputs and outputs of each step. 
  This makes it easier to handle retries, error handling, and recovery from failures.
- **Visual Workflow Editor:** AWS Step Functions provides a visual workflow editor that allows you to design and visualize your workflows using a graphical interface. 
- **Scalability:** Step Functions are highly scalable and can handle workflows of any size, from simple linear workflows to complex branching and parallel execution.
- **Integration with AWS Services:** Step Functions integrate seamlessly with other AWS services, allowing you to trigger workflows based on events from services like S3, SQS, SNS, and more.
- **Cost Optimization:** Step Functions are serverless, meaning you only pay for the resources you use and you don't need to manage any infrastructure.
- **Error Handling and Retries:** Step Functions provide built-in support for error handling and retries. 

Example:
```json
{
  "Comment": "Image Processing Workflow",
  "StartAt": "ProcessImage",
  "States": {
    "ProcessImage": {
      "Type": "Task",
      "Resource": "arn:aws:lambda:REGION:ACCOUNT_ID:function:ProcessImageFunction",
      "Parameters": {
        "Input.$": "$.imageKey",
        "Output.$": "$.filteredImageKey"
      },
      "Next": "StoreFilteredImage"
    },
    "StoreFilteredImage": {
      "Type": "Task",
      "Resource": "arn:aws:states:::s3:putObject",
      "Parameters": {
        "Bucket": "FILTERED_IMAGE_BUCKET_NAME",
        "Key": "$.filteredImageKey",
        "Body.$": "$.filteredImageData"
      },
      "End": true
    }
  }
}

```

## Lambda
Questions:
1. Explain the concept of cold and warm starts in AWS Lambda
2. What's the difference between synchronous and asynchronous invocation in AWS Lambda?
3. How do you implement error handling and retry logic in Lambda?
4. Explain your workflows for development and deployment of AWS Lambda functions
5. Can one lambda function call another lambda function?
6. Can you execute queries on an RDS instance (in a private subnet) using Lambda?
7. How do you manage concurrency and scaling in AWS Lambda?
8. How do you pass environment variables (sensitive/non-sensitive data) to AWS Lambda?
9. How do you re-use code across AWS Lambda functions?
10. What happens to your lambda functions if you delete a Lambda Layer?
11. 

Refs:
- https://www.freecodecamp.org/news/aws-lambda-interview-questions/
- https://medium.com/@nbkumar2103/-a998096b2c90

### Lambda Layers
Refs: 
- https://www.youtube.com/watch?v=QDBg2vp6vKY


## Serverless framework

### Refs:
- https://www.youtube.com/playlist?list=PLmexTtcbIn_gP8bpsUsHfv-58KsKPsGEo